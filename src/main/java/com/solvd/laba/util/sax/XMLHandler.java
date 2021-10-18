package com.solvd.laba.util.sax;

import com.solvd.laba.binary.Visitor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.Date;
import java.util.ArrayList;

public class XMLHandler extends DefaultHandler {
    private static ArrayList<Visitor> visitors = new ArrayList<>();
    private String lastElementName;
    private Integer id;
    private String name;
    private String surname;
    private Date birthday;
    private String address;
    private String diagnosis;
    private Date visitDate;
    private Date dischargeDate;

    private static final Logger LOGGER = LogManager.getLogger(XMLHandler.class);

    public static ArrayList<Visitor> getVisitors() {
        return visitors;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        this.lastElementName = qName;
        if (qName.equals("Visitor")) {
            this.id = Integer.valueOf(attributes.getValue("id"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("dischargeDate") && !this.name.isEmpty() && !surname.isEmpty() && birthday != null
                && !address.isEmpty() && !diagnosis.isEmpty() && visitDate != null) {

            visitors.add(new Visitor(id, name, surname, birthday, address, diagnosis, visitDate, dischargeDate));
            id = null;
            name = null;
            surname = null;
            birthday = null;
            address = null;
            diagnosis = null;
            visitDate = null;
            dischargeDate = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String information = new String(ch, start, length);
        information = information.replace("\n", "").trim();

        if (!information.isEmpty()) {
            switch (lastElementName) {
                case "name":
                    this.name = information;
                    break;
                case "surname":
                    this.surname = information;
                    break;
                case "birthday":
                    this.birthday = Date.valueOf(information);
                    break;
                case "address":
                    this.address = information;
                    break;
                case "diagnosis":
                    this.diagnosis = information;
                    break;
                case "visitDate":
                    this.visitDate = Date.valueOf(information);
                    break;
                case "dischargeDate":
                    if (!information.equals("null")) {
                        this.dischargeDate = Date.valueOf(information);
                    }
                    break;
            }
        }
    }
}
