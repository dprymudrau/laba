package com.solvd.laba.utils.parsers;

import com.solvd.laba.binary.Passenger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StaxParser {
    private static final Logger LOGGER = LogManager.getLogger(StaxParser.class);

    public static void staxParser() throws FileNotFoundException, XMLStreamException {
        File file = new File("src/main/resources/passenger.xml");

        // Instance of the class which helps on reading tags
        XMLInputFactory factory = XMLInputFactory.newInstance();

        // Initializing the handler to access the tags in the XML file
        XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(file));

        //All read employees objects will be added to this list
        List<Passenger> passengerList = new ArrayList<>();

        //Create Employee object. It will get all the data using setter methods.
        //And at last, it will stored in above 'employeeList'
        Passenger passenger = null;
        while (eventReader.hasNext()) {
            XMLEvent xmlEvent = eventReader.nextEvent();

            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();

                //As soo as employee tag is opened, create new Employee object
                if ("passenger".equalsIgnoreCase(startElement.getName().getLocalPart())) {
                    passenger = new Passenger();
                }

                //Read all attributes when start tag is being read
                @SuppressWarnings("unchecked")
                Iterator<Attribute> iterator = startElement.getAttributes();

                while (iterator.hasNext()) {
                    Attribute attribute = iterator.next();
                    QName name = attribute.getName();
                    if ("id".equalsIgnoreCase(name.getLocalPart())) {
                        passenger.setId(Integer.valueOf(attribute.getValue()));
                    }
                }

                //Now everytime content tags are found;
                //Move the iterator and read data
                switch (startElement.getName().getLocalPart()) {
                    case "name":
                        Characters nameDataEvent = (Characters) eventReader.nextEvent();
                        passenger.setName(nameDataEvent.getData());
                        break;

                    case "title":
                        Characters titleDataEvent = (Characters) eventReader.nextEvent();
                        passenger.setPhoneNumber(titleDataEvent.getData());
                        break;
                }
            }

            if (xmlEvent.isEndElement()) {
                EndElement endElement = xmlEvent.asEndElement();

                //If employee tag is closed then add the employee object to list;
                //and be ready to read next employee data
                if ("passenger".equalsIgnoreCase(endElement.getName().getLocalPart())) {
                    passengerList.add(passenger);
                }
            }
        }

        LOGGER.info(passengerList);   //Verify read data

    }
}
