package com.solvd.laba.start;

import com.solvd.laba.dao.jdbc.realization.CarImpl;
import com.solvd.laba.dao.jdbc.realization.AddressImpl;
import com.solvd.laba.dao.jdbc.realization.GoodsImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.info("Start program \"Delivery Project\".");
        LOGGER.info("End program \"Delivery Project\".");

        AddressImpl addressImpl = new AddressImpl();
        LOGGER.info(addressImpl.getAddressDAOId(2));
        CarImpl carImpl = new CarImpl();
        LOGGER.info(carImpl.getCarDAOId(2));
        GoodsImpl goodsImpl = new GoodsImpl();
        LOGGER.info(goodsImpl.getGoodsDAOId(1));


        XMLstaxParser.staxParser();
        Jaxb.jaxbParser();
        XmlParsers.jacksonParser();
    }
}