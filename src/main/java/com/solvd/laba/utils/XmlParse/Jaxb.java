package com.solvd.laba.utils.XmlParse;

import com.solvd.laba.binary.Companies;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Jaxb {
    private static final Logger LOGGER = LogManager.getLogger(Jaxb.class);
    static Companies fromXmlToObject(String filePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Companies.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (Companies) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void convertObjectToXml(Companies companiesName, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Companies.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(companiesName, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void jaxbParser() {
        String JAXBFileNameToSave = "src/main/resources/JaxbW.xml";
        String JAXBFileNameToRead = "src/main/resources/JaxbX.xml";
        Companies departmentName = new Companies();
        Jaxb.convertObjectToXml(departmentName, JAXBFileNameToSave);
        Companies unmarshalDepartmentName = Jaxb.fromXmlToObject(JAXBFileNameToRead);
        if (unmarshalDepartmentName != null) {
            LOGGER.info(unmarshalDepartmentName.toString());
        }
    }
}
