package com.solvd.laba.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
    private final static Logger LOGGER = LogManager.getLogger(ConfigUtil.class);
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("app.properties"));
        } catch (IOException e) {
            LOGGER.warn("Failed to load properties!", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
