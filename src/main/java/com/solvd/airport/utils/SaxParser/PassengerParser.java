package com.solvd.airport.utils.SaxParser;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class PassengerParser {
    public ArrayList parseXml(InputStream in) {
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        try {
            PassengerParserHandler handler = new PassengerParserHandler();

            XMLReader parser = XMLReaderFactory.createXMLReader();

            parser.setContentHandler(handler);

            InputSource source = new InputSource(in);

            parser.parse(source);

            passengers = handler.getPassengersList();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passengers;
    }
}
