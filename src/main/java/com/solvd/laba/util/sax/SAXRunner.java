package com.solvd.laba.util.sax;

import com.solvd.laba.binary.Visitor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SAXRunner {
    private static final Logger LOGGER = LogManager.getLogger(SAXRunner.class);
//    private static ArrayList<Visitor> visitors = XMLHandler.getVisitors();


    public static void readXML() {
        SAXParser parser = getParser();
        XMLHandler handler = new XMLHandler();
        try {
            if (parser != null) {
                parser.parse(new File("src/main/resources/Visitors.xml"), handler);
            }
        } catch (IOException | SAXException e) {
            LOGGER.error(e);
        }
    }

    private static SAXParser getParser() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            return parser;
        } catch (ParserConfigurationException | SAXException e) {
            LOGGER.error(e);
        }
        return null;
    }

}
