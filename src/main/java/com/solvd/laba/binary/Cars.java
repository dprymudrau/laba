package com.solvd.laba.binary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Cars")
public class Cars {
    private static final Logger LOGGER = LogManager.getLogger(Cars.class);
    private String carName;
    private int taxiCompaniesId;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getTaxiCompaniesId() {
        return taxiCompaniesId;
    }

    public void setTaxiCompaniesId(int taxiCompaniesId) {
        this.taxiCompaniesId = taxiCompaniesId;
    }
}

