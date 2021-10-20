package com.solvd.laba.runner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.laba.binary.RegistrationCard;
import com.solvd.laba.binary.Visitor;
import com.solvd.laba.binary.WorldHealthOrganization;
import com.solvd.laba.service.impl.myBatis.RegistrationCardService;
import com.solvd.laba.util.DateConverter;
import com.solvd.laba.util.jaxb.JAXBImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) throws JAXBException {
//        MyConnectionPool connections = MyConnectionPool.getInstance();
//
//        new MyThread("01", connections);
//        new MyThread("02", connections);
//        new MyThread("03", connections);
//        new MyThread("04", connections);
//        new MyThread("05", connections);
//        new MyThread("06", connections);

//        CarDAOImpl dao = new CarDAOImpl();
//        dao.printByFilter("idCarFleet = 1");
//        dao.printAll();
//        CarFleetServiceImpl carFleetService = new CarFleetServiceImpl();
//        Car car = new Car(3, "BMW", "X6", "1378HM-7", 1);
//        carFleetService.insertNewCarToFleet(1, car);


        //sax
//        System.out.println();
//        SAXRunner.readXML();
//        ArrayList<Visitor> visitors = XMLHandler.getVisitors();
//        visitors.forEach(System.out::println);
//        VisitorDAOImpl visitorDAO = new VisitorDAOImpl();
//        for (Visitor visitor : visitors) {
//            visitorDAO.insertToTable(visitor.getName(), visitor.getSurname(), visitor.getBirthday(),
//                    visitor.getAddress(), visitor.getDiagnosis(), visitor.getVisitDate(), visitor.getDischargeDate());
//        }

        //jaxb
        String filePath = "src/main/resources/Visitor.xml";
        Visitor visitorToXml = new Visitor(88, "TestName", "Test", DateConverter.getUtilDate("1986-04-09"), "Minsk", "Covid", DateConverter.getUtilDate("2021-10-07"), DateConverter.getUtilDate("2021-12-09"));
        JAXBImpl jaxb = new JAXBImpl();
        jaxb.marshal(visitorToXml, filePath);
        Visitor visitorFromXml = jaxb.unmarshal(filePath);
        LOGGER.info(visitorFromXml);


        //mybatis
//        CarFleetServiceImpl carFleetService = new CarFleetServiceImpl();
//        CarService carService = new CarService();
//        CarFleet fleet = carFleetService.getCarFleetById(3);
//        LOGGER.info(fleet);
//        carService.deleteCarById(7);
//        LOGGER.info(carFleetService.countCurrentCarsAmount(fleet.getId()));
//        LOGGER.info(carFleetService.checkFreeParkingSlot(fleet.getId()));
//        LOGGER.info(carService.getAll());
//        Car car1 = new Car(8, "BMW", "X6", "1378HM-7", 3);
//        Car car2 = new Car(3, "GAZ", "32214 \"Gazel\"", "6351TE-7", 3);
//        LOGGER.info(carFleetService.doesCarFleetContainCar(fleet.getId(), car2));
//        Car newCar = new Car(7, "BMW", "X5", "1580HM-7", 3);
//        carFleetService.insertNewCarToFleet(3, newCar);
//        LOGGER.info(carService.getAll());
//        LOGGER.info(carFleetService.doesCarFleetContainCar(fleet.getId(), newCar));

//        VisitorService visitorService = new VisitorService();
//        ArrayList<Visitor> visitors = visitorService.getAllVisitors();
//        visitorService.deleteVisitorById(7);
//        LOGGER.info(visitors);
//        System.out.println();
//        Visitor newVisitor = new Visitor(7, "Vitaliy", "Shulga", new Date(1984-12-31), "Homeless", "Covid", new Date(2021-11-11), null);
//        visitorService.insertVisitor(newVisitor);
//        LOGGER.info(visitors);
//        RegistrationCardService regCardService = new RegistrationCardService();
//        ArrayList<RegistrationCard> cards = regCardService.getAllRegCards();
//        LOGGER.info(cards);
//        RegistrationCard newCardForNewVisitor = new RegistrationCard(7, 2, newVisitor.getId(), 3, 3);
//        regCardService.addRegCardToTable(newCardForNewVisitor);
//        LOGGER.info(regCardService.findRegCardByVisitorId(7));
//        RegistrationCard newConsoledCard = regCardService.createRegCardForNewVisitorByConsole(7, newVisitor);
//        LOGGER.info(newConsoledCard);

//        DoctorServiceImpl docService = new DoctorServiceImpl();
//        docService.patientExamination(newVisitor);

        //jackson (json)
        ObjectMapper om = new ObjectMapper();
        try {
            File file = new File("src/main/resources/world-health-organization.json");
            WorldHealthOrganization whOrg = om.readValue(file, WorldHealthOrganization.class);
            LOGGER.info(whOrg);
            file = new File("src/main/resources/covid-infected-list.json");
            ArrayList<Visitor> visitor = om.readValue(file, new TypeReference<>() {});
            //OR
//            JavaType jType = om.getTypeFactory().constructCollectionLikeType(List.class, Visitor.class);
//            ArrayList<Visitor> visitor = om.readValue(file, jType);

            LOGGER.info(visitor);
        } catch (IOException e) {
            LOGGER.error("Cannot parse json file" + e);
        }
    }
}
