package com.solvd.laba.utils.Parsers;

import com.solvd.laba.binary.Cars;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Jaxb {
    private static final Logger LOGGER = LogManager.getLogger(Jaxb.class);
    static Cars fromXmlToObject(String filePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Cars.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (Cars) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void convertObjectToXml(Cars carName, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Cars.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(carName, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void jaxbParser() {
        String JAXBFileNameToSave = "src/main/resources/JaxbW.xml";
        String JAXBFileNameToRead = "src/main/resources/JaxbX.xml";
        Cars departmentName = new Cars();
        departmentName.setCarName("Toyota");
        departmentName.setTaxiCompaniesId(20);
        Jaxb.convertObjectToXml(departmentName, JAXBFileNameToSave);
        Cars unmarshalDepartmentName = Jaxb.fromXmlToObject(JAXBFileNameToRead);
        if (unmarshalDepartmentName != null) {
            LOGGER.info(unmarshalDepartmentName.toString());
        }
    }
}

