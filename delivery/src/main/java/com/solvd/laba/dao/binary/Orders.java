package com.solvd.laba.dao.binary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Orders extends Base {
    private static final Logger LOGGER = LogManager.getLogger(Orders.class);
    private String data;
    private String customerId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
