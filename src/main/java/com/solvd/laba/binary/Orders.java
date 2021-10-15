package com.solvd.laba.binary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Orders extends Base {
    private static final Logger LOGGER = LogManager.getLogger(Orders.class);
    private int data;
    private String customerId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


    public void setData(int data) {
        this.data = data;
    }
}
