package com.solvd.laba;

import com.solvd.laba.binary.Adress;
import com.solvd.laba.binary.City;
import com.solvd.laba.service.MyService;
import com.solvd.laba.service.impl.jdbc.MyServiceImpl;//can mowe to impl.myBatis.MyServiceImpl
import com.solvd.laba.utils.XmlParse.XmlParsers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.solvd.laba.utils.BusinessLogic.businessLogic;


public class Main{
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        //->>>>> BusinessLogic <<<<<-
        businessLogic();

        Adress a = new Adress();
        a.setId(1);
        City b = new City();



        MyService myService = new MyServiceImpl();
        myService.doSmth();


        //->>>>> Xml Parser work <<<<<-
        XmlParsers.staxParser();
        XmlParsers.jaxbParser();
        XmlParsers.jacksonParser();

        //->>>>> MyBATIS  <<<<<-

    }
}
