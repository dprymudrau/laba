package com.solvd.laba;

//jdbc/myBatis

import com.solvd.laba.utils.XmlAndJsonParse.XmlAndJsonParsers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.solvd.laba.utils.BusinessLogic.businessLogic;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        XmlAndJsonParsers.staxParser();
        XmlAndJsonParsers.jaxbParser();
        XmlAndJsonParsers.jacksonParser();

        businessLogic();
    }
}
