package com.solvd.airport.utils.SaxParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        File passengersXmlFile = new File("C:/Users/User/IdeaProjects/SAX parser/src/passengers.xml");
        PassengerParser passengerParser = new PassengerParser();
        ArrayList passengers = passengerParser.parseXml(new FileInputStream(passengersXmlFile));
        System.out.println(passengers);

        File passengerAccountsXmlFile = new File("C:/Users/User/IdeaProjects/SAX parser/src/passengerAccounts.xml");
        PassengerAccountParser passengerAccountParser = new PassengerAccountParser();
        ArrayList passengerAccounts = passengerAccountParser.parseXml(new FileInputStream(passengerAccountsXmlFile));
        System.out.println(passengerAccounts);
    }
}
