package com.solvd.laba.binary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
@JsonIgnoreProperties(value = { "streetId" })
public class Driver {
    private static final Logger LOGGER = LogManager.getLogger(Driver.class);
    @JsonProperty("driverId")
    private int driverId;
    @JsonProperty("name")
    private String phoneNumber;
    @JsonProperty("phoneNumber")
    private String name;


    public Driver() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return driverId == driver.driverId && phoneNumber == driver.phoneNumber && Objects.equals(name, driver.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, driverId, phoneNumber);
    }
}
