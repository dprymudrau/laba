package com.solvd.airport.utils.SaxParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Stack;

public class PassengerParserHandler extends DefaultHandler {
    private ArrayList passengersList = new ArrayList();

    private Stack elementStack = new Stack();

    private Stack objectStack = new Stack();

    public void startDocument() throws SAXException {
    }

    public void endDocument() throws SAXException {
    }

    public void startElement(String url, String localName, String qName, Attributes attributes) throws SAXException {
        this.elementStack.push(qName);

        if ("passenger".equals(qName)) {
            Passenger passenger = new Passenger();

            if (attributes != null && attributes.getLength() == 1) {
                passenger.setIdPassenger(Integer.parseInt(attributes.getValue(0)));
            }
            this.objectStack.push(passenger);
        }
    }

    public void endElement(String url, String localName, String qName) throws SAXException {
        this.elementStack.pop();

        if ("passenger".equals(qName)) {
            Passenger passenger = (Passenger) this.objectStack.pop();
            this.passengersList.add(passenger);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();

        if (value.length() == 0) {
            return;
        }

        if ("name".equals(currentElement())) {
            Passenger passenger = (Passenger) this.objectStack.peek();
            passenger.setPassengerName(value);
        } else if ("phoneNumber".equals(currentElement())) {
            Passenger passenger = (Passenger) this.objectStack.peek();
            passenger.setPhoneNumber(value);
        } else if ("accountId".equals(currentElement())) {
            Passenger passenger = (Passenger) this.objectStack.peek();
            passenger.setAccountId(Integer.parseInt(value));
        }
    }

    private String currentElement() {
        return (String) this.elementStack.peek();
    }

    public ArrayList getPassengersList() {
        return passengersList;
    }
}
