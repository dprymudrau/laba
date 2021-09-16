package com.solvd.laba.utils.XmlParse;

import com.solvd.laba.binary.DepartmentName;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class Jaxb {
    static DepartmentName fromXmlToObject(String filePath) { // restore the object from the XML file
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DepartmentName.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (DepartmentName) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void convertObjectToXml(DepartmentName departmentName, String filePath) {   // save the object to XML file
        try {
            JAXBContext context = JAXBContext.newInstance(DepartmentName.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(departmentName, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
