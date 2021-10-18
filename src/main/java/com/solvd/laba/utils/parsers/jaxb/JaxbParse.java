package com.solvd.laba.utils.parsers.jaxb;


import com.solvd.laba.binary.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Date;


public class JaxbParse {
    private static final Logger LOGGER = LogManager.getLogger(JaxbParse.class);
        public static Car fromXmlToObject(String filePath) { // restore the object from the XML file
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
                Unmarshaller un = jaxbContext.createUnmarshaller();

                return (Car) un.unmarshal(new File(filePath));
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static void convertObjectToXml(Car car, String filePath) {   // save the object to XML file
            try {
                JAXBContext context = JAXBContext.newInstance(Car.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                marshaller.marshal(car, new File(filePath));
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    public static void jaxbParser() {
        String JAXBFileNameToSave = "src/main/resources/xmlAndJsonParsers/JaxbW.xml";
        String JAXBFileNameToRead = "src/main/resources/xmlAndJsonParsers/JaxbR.xml";
        Car car = new Car();
        car.setDateOfConstruct(new Date());
        //date adapter
        car.setCarName("Audi");
        car.setCarId(5);
        JaxbParse.convertObjectToXml(car, JAXBFileNameToSave);//save the object to XML file
        Car unmarshalDepartmentName = JaxbParse.fromXmlToObject(JAXBFileNameToRead);    //restoring an object from an XML file
        if (unmarshalDepartmentName != null) {
            LOGGER.info(unmarshalDepartmentName.toString());
        }

    }

    }

