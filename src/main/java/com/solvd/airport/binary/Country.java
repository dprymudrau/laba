package com.solvd.airport.binary;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Objects;

public class Country {
    @JsonProperty("id")
    private long idCountry;
    @JsonProperty("name")
    private String countryName;
    @JsonProperty("towns")
    private ArrayList<Town> towns;

    public ArrayList<Town> getTowns() {
        return towns;
    }

    @Override
    public String toString() {
        return "Country{" +
                "idCountry=" + idCountry +
                ", countryName='" + countryName + '\'' +
                ", towns=" + towns +
                '}';
    }

    public void setTowns(ArrayList<Town> towns) {
        this.towns = towns;
    }

    public long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(long idCountry) {
        this.idCountry = idCountry;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return idCountry == country.idCountry && countryName.equals(country.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCountry, countryName);
    }

}
