package com.solvd.laba.binary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Objects;
@JsonIgnoreProperties(value = { "cityId" })
public class Street {
    @JsonProperty("name")
    private String Name;
    @JsonProperty("id")
    private int streetId;
    @JsonProperty("num")
    private int number;
    private int cityId;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }


    public Street(String name, int streetId, int number) {
        Name = name;
        this.streetId = streetId;
        this.number = number;
    }

    public Street() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
        return streetId == street.streetId && number == street.number && Objects.equals(Name, street.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, streetId, number);
    }
}
