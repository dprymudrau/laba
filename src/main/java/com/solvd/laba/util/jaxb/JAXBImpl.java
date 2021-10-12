package com.solvd.laba.util.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class JAXBImpl {
    StringWriter writer = new StringWriter();

    public String marshaller(FullRegCardInfo obj) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(FullRegCardInfo.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, writer);

        return writer.toString();
    }

    public FullRegCardInfo unmarshaller(String xmldata) throws JAXBException {
        StringReader reader = new StringReader(xmldata);
        JAXBContext context = JAXBContext.newInstance(FullRegCardInfo.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (FullRegCardInfo) unmarshaller.unmarshal(reader);
    }
}
