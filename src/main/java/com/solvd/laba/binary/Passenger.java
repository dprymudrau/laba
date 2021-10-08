package com.solvd.laba.binary;

import java.util.Objects;

public class Passenger {
    private String Name;
    private int Id;

    public Passenger(String name, int id) {
        Name = name;
        Id = id;
    }

    public Passenger() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Id == passenger.Id && Objects.equals(Name, passenger.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Id);
    }
}
