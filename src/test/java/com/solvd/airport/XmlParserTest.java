package com.solvd.airport;

import com.solvd.airport.binary.Ticket;
import com.solvd.airport.utils.SaxParser.Passenger;
import com.solvd.airport.utils.SaxParser.PassengerAccount;
import com.solvd.airport.utils.SaxParser.PassengerAccountParser;
import com.solvd.airport.utils.SaxParser.PassengerParser;
import com.solvd.airport.utils.XsdValidate.XsdValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class XmlParserTest {

    private JAXBContext context;

    @Test
    public void saxParserTest(){
        try {
            File passengersXmlFile = new File("src/test/resources/passengers.xml");
            PassengerParser passengerParser = new PassengerParser();
            ArrayList<Passenger> passengers = passengerParser.parseXml(new FileInputStream(passengersXmlFile));
            Assert.assertEquals(passengers.size(), 2);
            Assert.assertEquals(passengers.get(0).getPassengerName(), "Tom");

            File passengerAccountsXmlFile = new File("src/test/resources/passengerAccounts.xml");
            PassengerAccountParser passengerAccountParser = new PassengerAccountParser();
            ArrayList<PassengerAccount> passengerAccounts = passengerAccountParser.parseXml(new FileInputStream(passengerAccountsXmlFile));
            Assert.assertEquals(passengerAccounts.size(), 2);
            Assert.assertNotEquals(passengerAccounts.get(1).getFullName(), "Tom Tom Tom");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jaxbMarshallerTest(){
        com.solvd.airport.binary.Passenger passenger = new com.solvd.airport.binary.Passenger();
        passenger.setIdPassenger(1);
        passenger.setPassengerName("XXX");
        passenger.setPhoneNumber("XX-XXX-XXX");
        Ticket ticket1 = new Ticket();
        ticket1.setIdTicket(1);
        ticket1.setDateOfBuying(Date.valueOf(LocalDate.EPOCH));
        ticket1.setFlightId(1);
        ticket1.setPassengerId(1);
        ticket1.setPlaceNumber(1);
        ArrayList<Integer> x = new ArrayList<>();
        x.add(1); x.add(2); x.add(3);
        ticket1.setSomeIds(x);
        ticket1.setPassenger(passenger);
        try {
            Marshaller marshaller = null;
            marshaller = this.context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(ticket1, new File("src/test/resources/ticketX.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        boolean validationResult = XsdValidator.validateXMLSchema("src/test/resources/xsdFiles/ticket.xsd", "src/test/resources/ticketX.xml");
        Assert.assertEquals(validationResult, true);
    }

    @Test
    public void jaxbUnmarshallerTest(){
        Ticket ticket2 = new Ticket();
        try {
            Unmarshaller jaxbUnmarshaller = this.context.createUnmarshaller();
            ticket2 =(Ticket) jaxbUnmarshaller.unmarshal(new File("src/test/resources/ticket.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(ticket2.getIdTicket(),1);
        Assert.assertNotEquals(ticket2.getPassenger(), null);
        Assert.assertEquals(ticket2.getSomeIds().size(),3);
    }

    @BeforeTest
    public void JaxbContextCreator(){
        try {
            context = JAXBContext.newInstance(Ticket.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
