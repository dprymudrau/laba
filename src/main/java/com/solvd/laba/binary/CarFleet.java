package com.solvd.laba.binary;

import java.util.Objects;

public class CarFleet {
    private int id;
    private int capacityByCars;

    public CarFleet(int id, int capacityByCars) {
        this.id = id;
        this.capacityByCars = capacityByCars;
    }

    public CarFleet() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacityByCars() {
        return capacityByCars;
    }

    public void setCapacityByCars(int capacityByCars) {
        this.capacityByCars = capacityByCars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarFleet)) return false;
        CarFleet carFleet = (CarFleet) o;
        return id == carFleet.id && capacityByCars == carFleet.capacityByCars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, capacityByCars);
    }

    @Override
    public String toString() {
        return "CarFleet{" +
                "id=" + id +
                ", capacityByCars=" + capacityByCars +
                '}';
    }
}
