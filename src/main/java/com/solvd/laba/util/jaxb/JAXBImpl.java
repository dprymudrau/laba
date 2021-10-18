package com.solvd.laba.util.jaxb;

import com.solvd.laba.binary.Visitor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class JAXBImpl {
    private final static Logger LOGGER = LogManager.getLogger(JAXBImpl.class);

    public void marshal(Visitor obj, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Visitor.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, new File(filePath));
        } catch (JAXBException e) {
            LOGGER.error(e);
        }

    }

    public Visitor unmarshal(String xmlPath) {
        try {
            FileReader reader = new FileReader(xmlPath);
            JAXBContext context = JAXBContext.newInstance(Visitor.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            return (Visitor) unmarshaller.unmarshal(reader);
        } catch (JAXBException | IOException e) {
            LOGGER.error(e);
        }
        return null;
    }
}
