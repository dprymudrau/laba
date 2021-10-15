package com.solvd.laba.binary;

import java.util.Objects;

public class Streets {
    private String Name;
    private int streetId;
    private int number;

    public Streets(String name, int streetId, int number) {
        Name = name;
        this.streetId = streetId;
        this.number = number;
    }

    public Streets() {

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
        Streets streets = (Streets) o;
        return streetId == streets.streetId && number == streets.number && Objects.equals(Name, streets.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, streetId, number);
    }
}
