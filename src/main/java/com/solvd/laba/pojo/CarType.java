package com.solvd.laba.pojo;

import java.util.Objects;

public class CarType {
    private String carName;
    private int taxiCompaniesId;

    public CarType(String carName, int taxiCompaniesId) {
        this.carName = carName;
        this.taxiCompaniesId = taxiCompaniesId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getTaxiCompaniesId() {
        return taxiCompaniesId;
    }

    public void setTaxiCompaniesId(int taxiCompaniesId) {
        this.taxiCompaniesId = taxiCompaniesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarType carType = (CarType) o;
        return taxiCompaniesId == carType.taxiCompaniesId && Objects.equals(carName, carType.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, taxiCompaniesId);
    }
}
