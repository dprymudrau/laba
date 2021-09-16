package com.solvd.laba.binary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class City extends BaseEntityID{
    private static final Logger LOGGER = LogManager.getLogger(City.class);
    private String city;
    private String codeNumber;
    private int adressID;

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCodeNumber() {
        return codeNumber;
    }
    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }
    public int getAdressID() {
        return adressID;
    }
    public void setAdressID(int adressID) {
        this.adressID = adressID;
    }

    @Override
    public String toString() {
        String id = super.toString();
        return "City{" + id +
                ", city='" + city + '\'' +
                ", codeNumber='" + codeNumber + '\'' +
                ", adressID=" + adressID +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        City guest = (City) obj;
        boolean b = super.equals(obj) && (guest.city == this.city)&& (guest.codeNumber == this.codeNumber)&& (guest.adressID == this.adressID);
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), city, codeNumber, adressID);
    }
}
