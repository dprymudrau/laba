package com.solvd.laba.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatis {
    private static SqlSessionFactory factory;
    private final static MyBatis myBatisFactory = new MyBatis();

    private MyBatis(){
        try{
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSessionFactory(){
        return factory;
    }
}
