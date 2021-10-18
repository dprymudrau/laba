package com.solvd.laba.start;

import com.solvd.laba.service.implementation.jdbc.*;
import com.solvd.laba.service.interfaces.*;
import com.solvd.laba.utils.parsers.JacksonParser;
import com.solvd.laba.utils.parsers.jaxb.Jaxb;
import com.solvd.laba.utils.parsers.StaxParser;
import com.solvd.laba.utils.parsers.jaxb.JaxbParse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        CarService car = new CarServiceImpl();
        LOGGER.info(car.getById(1));

        DriverService driver = new DriverServiceImpl();
        LOGGER.info(driver.getById(1));

        OrderService order = new OrderServiceImpl();
        LOGGER.info(order.getById(1));

        PassengerService passengers = new PassengerServiceImpl();
        LOGGER.info(passengers.getById(2));

        StreetService street = new StreetServiceImpl();
        LOGGER.info(street.getById(1));

        StaxParser.staxParser();
        JaxbParse.jaxbParser();
        //JacksonParser.jacksonParser();
    }
}