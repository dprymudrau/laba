package com.solvd.laba.start;

import com.solvd.laba.service.jdbc.implementation.DriversImpl;
import com.solvd.laba.service.jdbc.implementation.ListOfOrdersImpl;
import com.solvd.laba.service.jdbc.implementation.PassengersImpl;
import com.solvd.laba.utils.Parsers.Jaxb;
import com.solvd.laba.utils.Parsers.StaxParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {


        DriversImpl addressImpl = new DriversImpl();
        LOGGER.info(addressImpl.getDriversDAOId(1));
        PassengersImpl carImpl = new PassengersImpl();
        LOGGER.info(carImpl.getPassengerDAOId(2));
        ListOfOrdersImpl goodsImpl = new ListOfOrdersImpl();
        LOGGER.info(goodsImpl.getListOfOrdersImplDAOId(1));


        StaxParser.staxParser();
        Jaxb.jaxbParser();
    }
}