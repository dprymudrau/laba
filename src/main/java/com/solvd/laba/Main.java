package com.solvd.laba;

import com.solvd.laba.service.MyService;
//jdbc/myBatis
import com.solvd.laba.service.ProjectServise;
import com.solvd.laba.service.impl.jdbc.MyServiceImpl;
import com.solvd.laba.service.impl.jdbc.ProjectImpl;
import com.solvd.laba.service.impl.myBatis.ParserServiseImpl;
import com.solvd.laba.utils.XmlAndJsonParse.XmlAndJsonParsers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        XmlAndJsonParsers.staxParser();
        XmlAndJsonParsers.jaxbParser();
        XmlAndJsonParsers.jacksonParser();

        LOGGER.info("Start \"JDBC/MyBATIS\".");
        MyService myService = new MyServiceImpl();
        ProjectServise projectServise = new ProjectImpl();
        myService.doSmth();
        ParserServiseImpl.staxParser("src/main/resources/xmlAndJsonParsers/Stax.xml");
        ParserServiseImpl.jaxbParser("src/main/resources/xmlAndJsonParsers/JaxbR.xml", "src/main/resources/xmlAndJsonParsers/JaxbW.xml");
        ParserServiseImpl.jacksonParser("{ \"emails\":\"mail\"}");
        LOGGER.info("End \"JDBC/MyBATIS\".");
    }
}
