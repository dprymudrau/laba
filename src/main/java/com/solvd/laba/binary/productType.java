package com.solvd.laba.binary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class productType extends Base{
    private static final Logger LOGGER = LogManager.getLogger(productType.class);
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
