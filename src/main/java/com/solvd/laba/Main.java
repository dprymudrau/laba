package com.solvd.laba;

import com.solvd.laba.service.MyService;
//jdbc/myBatis
import com.solvd.laba.service.impl.jdbc.MyServiceImpl;
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
        //myService.getById(0);
        LOGGER.info("End \"JDBC/MyBATIS\".");
        //->>>>> apiTests2  <<<<<-
        //https://api.openweathermap.org/data/2.5/weather?q=Kiev&appid=b251a86444ad47078e0fd0b41782ad83
        //https://api.openweathermap.org/data/2.5/weather?q=Minsk&appid=b251a86444ad47078e0fd0b41782ad83
        //https://api.openweathermap.org/data/2.5/weather?q=London&appid=b251a86444ad47078e0fd0b41782ad83
        //https://api.openweathermap.org/data/2.5/weather?q=Tokio&appid=b251a86444ad47078e0fd0b41782ad83
        //https://api.openweathermap.org/data/2.5/weather?q=Madrid&appid=b251a86444ad47078e0fd0b41782ad83
    }
}
