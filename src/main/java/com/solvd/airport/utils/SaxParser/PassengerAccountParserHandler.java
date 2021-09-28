package com.solvd.airport.utils.SaxParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Stack;

public class PassengerAccountParserHandler extends DefaultHandler {
    private ArrayList passengerAccountsList = new ArrayList();

    private Stack elementStack = new Stack();

    private Stack objectStack = new Stack();

    public void startDocument() throws SAXException {
    }

    public void endDocument() throws SAXException {
    }

    public void startElement(String url, String localName, String qName, Attributes attributes) throws SAXException {
        this.elementStack.push(qName);

        if ("passengerAccount".equals(qName)) {
            PassengerAccount passengerAccount = new PassengerAccount();

            if (attributes != null && attributes.getLength() == 1) {
                passengerAccount.setIdPassengerAccount(Integer.parseInt(attributes.getValue(0)));
            }
            this.objectStack.push(passengerAccount);
        }
    }

    public void endElement(String url, String localName, String qName) throws SAXException {
        this.elementStack.pop();

        if ("passengerAccount".equals(qName)) {
            PassengerAccount passengerAccount = (PassengerAccount) this.objectStack.pop();
            this.passengerAccountsList.add(passengerAccount);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();

        if (value.length() == 0) {
            return;
        }

        if ("fullName".equals(currentElement())) {
            PassengerAccount passengerAccount = (PassengerAccount) this.objectStack.peek();
            passengerAccount.setFullName(value);
        } else if ("passportNumber".equals(currentElement())) {
            PassengerAccount passengerAccount = (PassengerAccount) this.objectStack.peek();
            passengerAccount.setPassportNumber(value);
        }
    }

    private String currentElement() {
        return (String) this.elementStack.peek();
    }

    public ArrayList getPassengerAccountsList() {
        return passengerAccountsList;
    }
}
