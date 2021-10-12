package com.solvd.laba.start;

import com.solvd.laba.service.implementation.myBatis.PassengersImpl;
import com.solvd.laba.service.implementation.jdbc.*;
import com.solvd.laba.service.interfaces.*;
import com.solvd.laba.utils.Parsers.Jaxb.Jaxb;
import com.solvd.laba.utils.Parsers.StaxParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {


        IDrivers drivers = new DriversImpl();
        LOGGER.info(drivers.getDriversDAOId(1));

        IListOfOrders listOfOrders = new ListOfOrdersImpl();
        LOGGER.info(listOfOrders.getListOfOrdersDAOId(1));

        IOrders orders = new OrdersImpl();
        LOGGER.info(orders.getOrdersDAOId(1));

        IPassengers passengers = new PassengersImpl();
        LOGGER.info(passengers.getPassengerDAOId(2));

        IStreets streets = new StreetsImpl();
        LOGGER.info(streets.getStreetsDAOId(1));



        StaxParser.staxParser();
        Jaxb.jaxbParser();
    }
}