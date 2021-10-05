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
        //->>>>> BusinessLogic <<<<<-
        businessLogic();
        //->>>>> Xml Parser work <<<<<-
        XmlAndJsonParsers.staxParser();
        XmlAndJsonParsers.jaxbParser();
        XmlAndJsonParsers.jacksonParser();
        //->>>>> MyBATIS  <<<<<-
        MyService myService = new MyServiceImpl();
        myService.doSmth();
    }
}
