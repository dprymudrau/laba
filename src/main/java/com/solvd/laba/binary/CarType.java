package com.solvd.laba.binary;

import java.util.Objects;

public class CarType {
    private String carTypeName;
    private int carTypeId;

    public CarType() {
        this.carTypeName = carTypeName;
        this.carTypeId = carTypeId;
    }

    public String getCarTypeName() {
        return carTypeName;
    }

    public void setCarTypeName(String carTypeName) {
        this.carTypeName = carTypeName;
    }

    public int getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(int carTypeId) {
        this.carTypeId = carTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarType carType = (CarType) o;
        return carTypeId == carType.carTypeId && Objects.equals(carTypeName, carType.carTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carTypeName, carTypeId);
    }
}

