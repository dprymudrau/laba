package com.solvd.laba.binary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeliveryLocation extends Base {
    private static final Logger LOGGER = LogManager.getLogger(DeliveryLocation.class);
    private String locationAddress;
    private String locationName;
    private String otherLocationDetails;

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
    public String getOtherLocationDetails() {
        return otherLocationDetails;
    }

    public void setOtherLocationDetails(String otherLocationDetails) {
        this.otherLocationDetails = otherLocationDetails;
    }
}
