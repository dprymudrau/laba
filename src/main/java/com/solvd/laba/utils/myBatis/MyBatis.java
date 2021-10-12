package com.solvd.laba.utils.myBatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatis {
    private static SqlSessionFactory factory;
    private final static MyBatis myBatis = new MyBatis();

    private MyBatis(){
        try{
            Reader reader = Resources.getResourceAsReader("MyBatis.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSessionFactory(){
        return factory;
    }
}

