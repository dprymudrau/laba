package com.solvd.laba.utils;

import com.solvd.laba.binary.Emploee;
import com.solvd.laba.dao.jdbc.impl.*;
import com.solvd.laba.service.MyService;
import com.solvd.laba.service.ProjectServise;
import com.solvd.laba.service.SetContactData;
import com.solvd.laba.service.SetNameServise;
import com.solvd.laba.service.impl.jdbc.*;
import com.solvd.laba.service.impl.myBatis.ParserServiseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BusinessLogic {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void businessLogic(){

        LOGGER.info("Start \"JDBC/MyBATIS\".");
        MyService myService = new MyServiceImpl();
        ProjectServise projectServise = new ProjectImpl();
        SetContactData sCData = new CustContactDataImpl();
        SetContactData sItData = new ItContactDataImpl();
        SetNameServise sCName = new SetCustNameImpl();
        sCName = new SetCustNameImpl(sCName);
        SetNameServise sItName = new SetItNameImpl();
        sItName = new SetItNameImpl(sItName);
        myService.doSmth();

        ParserServiseImpl.staxParser("src/main/resources/xmlAndJsonParsers/Stax.xml");
        ParserServiseImpl.jaxbParser("src/main/resources/xmlAndJsonParsers/JaxbR.xml", "src/main/resources/xmlAndJsonParsers/JaxbW.xml");
        ParserServiseImpl.jacksonParser("{ \"emails\":\"mail\"}");
        LOGGER.info("End \"JDBC/MyBATIS\".");
    }

}
