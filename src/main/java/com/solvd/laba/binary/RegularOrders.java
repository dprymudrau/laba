package com.solvd.laba.binary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegularOrders extends Base{
    private static final Logger LOGGER = LogManager.getLogger(RegularOrders.class);
    private String otherDetails;

    public String getOtherDetails() {
        return otherDetails;
    }
    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

}
