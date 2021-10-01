package com.solvd.laba.start;

import com.solvd.laba.pojo.Cars;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
public class Jaxb {
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

}

