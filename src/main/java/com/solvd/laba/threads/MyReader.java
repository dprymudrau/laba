package com.solvd.laba.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MyReader {

    private static final Logger LOGGER = LogManager.getLogger(MyReader.class);

    public static String readTextFileOrGetNull(Path filePath) {
        try {
            return Files.readString(filePath);
        }
        catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("File not found!");
        }
        return null;
    }

    public static String[] splitTheStringWithText(String text) {
        if (text.isEmpty()) throw new NullPointerException("String is empty!");
        return text.split("\n");
    }
}
