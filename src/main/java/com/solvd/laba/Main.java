package com.solvd.laba;

import com.solvd.laba.service.MyService;
import com.solvd.laba.service.impl.jdbc.MyServiceImpl;
import com.solvd.laba.utils.XmlAndJsonParse.XmlAndJsonParsers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.solvd.laba.utils.BusinessLogic.businessLogic;


public class Main{
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Start program \"Delivery Project\".");
        //->>>>> Xml Parser work <<<<<-
        //XmlAndJsonParsers.staxParser();
        //XmlAndJsonParsers.jaxbParser();
        //XmlAndJsonParsers.jacksonParser();
        //->>>>> JDBC/MyBATIS  <<<<<-
        MyService myService = new MyServiceImpl();
        myService.doSmth();
        LOGGER.info(" LOGGER.info текст");
        System.out.println("System.out.println текст");
    }
}
