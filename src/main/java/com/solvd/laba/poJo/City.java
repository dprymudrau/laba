package com.solvd.laba.poJo;

import java.util.Objects;

public class City {
    private int id;
    private String city;
    private String codeNumber;
    private int adressID;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
        return "City{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", codeNumber='" + codeNumber + '\'' +
                ", adressID=" + adressID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return id == city1.id && adressID == city1.adressID && city.equals(city1.city) && codeNumber.equals(city1.codeNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, codeNumber, adressID);
    }
}
