package com.solvd.laba.utils.parsers.jaxb;

import com.solvd.laba.binary.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Jaxb extends DateAdapter {
    private static final Logger LOGGER = LogManager.getLogger(Jaxb.class);

    public static void jaxbParser()
    {
        String xmlFile = "src/main/resources/JaxbW.xml";

        jaxbXmlFileToObject(xmlFile);
    }

    private static void jaxbXmlFileToObject(String xmlFile) {

        JAXBContext jaxbContext;

        try
        {
            //Get JAXBContext
            jaxbContext = JAXBContext.newInstance(Car.class);

            //Create Unmarshaller
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();



            //Unmarshal xml file
            Car car = (Car) jaxbUnmarshaller.unmarshal(new File(xmlFile));
            LOGGER.info(car);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}

