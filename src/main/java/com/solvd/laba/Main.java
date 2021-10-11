package com.solvd.laba;

import com.solvd.laba.service.MyService;
//jdbc/myBatis
import com.solvd.laba.service.impl.myBatis.MyServiceImpl;
import com.solvd.laba.utils.XmlAndJsonParse.XmlAndJsonParsers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        //->>>>> Xml Parser work <<<<<-
        XmlAndJsonParsers.staxParser();
        XmlAndJsonParsers.jaxbParser();
        XmlAndJsonParsers.jacksonParser();
        //->>>>> JDBC/MyBATIS  <<<<<-
        LOGGER.info("Start \"JDBC/MyBATIS\".");
        MyService myService = new MyServiceImpl();
        myService.doSmth();
        //myService.getById(2);
        LOGGER.info("End \"JDBC/MyBATIS\".");
    }
}
