package com.solvd.laba.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final Logger LOGGER = LogManager.getLogger(Config.class);
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("src/main/resources/app.properties"));
        } catch (IOException e) {
            LOGGER.error("Failed to load properties", e);        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
