package com.solvd.laba.dao;

import com.solvd.laba.dao.service.MyService;
import com.solvd.laba.dao.service.impl.jdbc.MyServiceImpl;//can mowe to impl.myBatis.MyServiceImpl
import com.solvd.laba.dao.utils.XmlParse.XmlParsers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Main{
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        XmlParsers.staxParser();
        XmlParsers.jaxbParser();
        XmlParsers.jacksonParser();


    }
}

