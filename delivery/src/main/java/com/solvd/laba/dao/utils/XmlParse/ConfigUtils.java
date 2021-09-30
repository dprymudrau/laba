package main.java.com.solvd.laba.dao.util.XmlParse;

import com.solvd.laba.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
    private static final Logger LOGGER = LogManager.getLogger(ConfigUtils.class);
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

