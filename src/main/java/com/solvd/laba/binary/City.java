package com.solvd.laba.binary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(value = { "cityId", "name", "id", "street", "city" })
public class City {
    @JsonProperty("id")
    private String Name;
    @JsonProperty("name")
    private int Id;
    ArrayList<City> city;

    public ArrayList<City> getCity() {
        return city;
    }

    public City(String name, int id) {
        Name = name;
        Id = id;
    }

    public City() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setStreet(Street street1) {
    }

    public int getStreet() {
        return 0;
    }
}
