package com.solvd.laba.binary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Objects;

@JsonIgnoreProperties(value = {"cityId"})
public class Street {
    @JsonProperty("streetId")
    private int streetId;
    @JsonProperty("streetName")
    private String streetName;

    private int number;

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }

    @JsonProperty("drivers")
    private ArrayList<Driver> drivers;


    public Street(String streetName, int streetId, int number) {
        streetName = streetName;
        this.streetId = streetId;
        this.number = number;
    }

    public Street() {

    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String name) {
        streetName = name;
    }

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return streetId == street.streetId && number == street.number && Objects.equals(streetName, street.streetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetName, streetId, number);
    }

    public void setDriver(ArrayList<Driver> drivers) {
    }
}
