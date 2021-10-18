package com.solvd.laba.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class MyBatisFactory {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisFactory.class);
    private static SqlSessionFactory factory;
    private static final MyBatisFactory myBatisFactory = new MyBatisFactory();

    private MyBatisFactory() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            LOGGER.error("Unreadable file..." + e);
        }
    }

    public static SqlSessionFactory getSessionFactory() {
        return factory;
    }
}
