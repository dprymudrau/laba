package com.solvd.laba.binary;

import java.util.Objects;

public class Street {
    private String Name;
    private int streetId;
    private int number;

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
