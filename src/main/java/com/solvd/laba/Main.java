package com.solvd.laba;

import com.solvd.laba.poJo.Adress;

import com.solvd.laba.poJo.City;
import com.solvd.laba.utils.XmlParse.XmlParsers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main{
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        //->>>>> BusinessLogic <<<<<-
        Adress a = new Adress();
        a.setId(1);
        City b = new City();

//        for(int i=1; i < 10; i++){
//            new Threads("Thread"+i).start();
//
//        }

        //->>>>> Xml Parser work <<<<<-
        XmlParsers parser = new XmlParsers();

    }
}
