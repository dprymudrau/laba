package com.solvd.laba.binary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
@JsonIgnoreProperties(value = {})
public class City {
    @JsonProperty("cityId")
    private int cityId;
    @JsonProperty("cityName")
    private String cityName;


    public ArrayList<Street> getStreets() {
        return streets;
    }

    public void setStreets(ArrayList<Street> streets) {
        this.streets = streets;
    }

    @JsonProperty("streets")
    ArrayList<Street> streets;


    public City(String name, int id) {
        cityName = cityName;
        cityId = id;
    }

    public City() {

    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String name) {
        cityName = cityName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int id) {
        cityId = id;
    }

}
