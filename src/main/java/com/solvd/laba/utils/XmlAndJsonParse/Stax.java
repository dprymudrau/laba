package com.solvd.laba.utils.XmlAndJsonParse;

import com.solvd.laba.binary.City;

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

public class Stax {

    public static List<City> parseXmlByStax(String fileName) {
        List<City> cityList = new ArrayList<>();
        City city = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName)); //init reader
            while (reader.hasNext()) {                   //skan xml elements
                XMLEvent xmlEvent = reader.nextEvent();  // get xml atribures
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("City")) {
                        city = new City();
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if (idAttr != null) {
                            city.setId(Integer.parseInt(idAttr.getValue()));
                        }
                    } else if (startElement.getName().getLocalPart().equals("city")) {
                        xmlEvent = reader.nextEvent();
                        city.setCity(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("codeNumber")) {
                        xmlEvent = reader.nextEvent();
                        city.setCodeNumber(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("adressID")) {
                        xmlEvent = reader.nextEvent();
                        city.setAdressID(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }
                }
                // if the loop has reached the closing City element,
                // then add the city read from the file to the list
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("City")) {
                        cityList.add(city);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException exc) {
            exc.printStackTrace();
        }
        return cityList;
    }
}
