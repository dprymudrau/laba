package com.solvd.laba.utils.Parsers;
import com.solvd.laba.pojo.Drivers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XMLstaxParser {
    private static final Logger LOGGER = LogManager.getLogger(XMLstaxParser.class);
    public static List<Drivers> parseXmlByStax(String fileName) {
        List<Drivers> driversList = new ArrayList<>();
        Drivers drivers = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("Drivers")) {
                        drivers = new Drivers();
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if (idAttr != null) {
                            drivers.setId(Integer.parseInt(idAttr.getValue()));
                        }
                    } else if (startElement.getName().getLocalPart().equals("name")) {
                        xmlEvent = reader.nextEvent();
                        drivers.setName(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("Age")) {
                        xmlEvent = reader.nextEvent();
                        drivers.setAge(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("phoneNumber")) {
                        xmlEvent = reader.nextEvent();
                        drivers.setPhoneNumber(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }
                }

                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("Drivers")) {
                        driversList.add(drivers);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException exc) {
            exc.printStackTrace();
        }
        return driversList;
    }
    public static void staxParser() {
        String STAXFileName = "src/main/resources/myStax.xml";
        List<Drivers> cityList = XMLstaxParser.parseXmlByStax(STAXFileName);
        for (Drivers city : cityList) {
            LOGGER.info(city.toString());
        }
    }
}