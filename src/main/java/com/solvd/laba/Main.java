package com.solvd.laba;

import com.solvd.laba.dao.pool.Threads;
import com.solvd.laba.utils.ConfigUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main{
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static String url;
    private static String username;
    private static String password;
    public static void main(String[] args) throws SQLException {
        loadConfigs();
        LOGGER.info("url = "+ url);
        LOGGER.info("username = "+username);
        LOGGER.info("password = "+password);
//        for(int i=1; i < 10; i++){
//            new Threads("Thread"+i).start();
//        }
        try{
        try (Connection conn = DriverManager.getConnection(url, username, password)){

            System.out.println("Connection to Store DB succesfull!");
        }
    }
         catch(Exception ex){
        System.out.println("Connection failed...");

        System.out.println(ex);
    }

    }
    private static void loadConfigs(){
        ConfigUtils config = new ConfigUtils();
        url = config.getProperty("url");
        username = config.getProperty("username");
        password = config.getProperty("password");
    }


}
