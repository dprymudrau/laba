package com.solvd.airport.utils.SaxParser;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class PassengerAccountParser {
    public ArrayList parseXml(InputStream in) {
        ArrayList passengers = new ArrayList<PassengerAccount>();
        try {
            PassengerAccountParserHandler handler = new PassengerAccountParserHandler();

            XMLReader parser = XMLReaderFactory.createXMLReader();

            parser.setContentHandler(handler);

            InputSource source = new InputSource(in);

            parser.parse(source);

            passengers = handler.getPassengerAccountsList();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passengers;
    }
}