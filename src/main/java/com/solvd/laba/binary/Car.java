package com.solvd.laba.binary;

import java.util.Objects;

public class Car {
    private int id;
    private String brandName;
    private String model;
    private String regNumber;
    private int idCarFleet;

    public Car(int id, String brandName, String model, String regNumber, int idCarFleet) {
        this.id = id;
        this.brandName = brandName;
        this.model = model;
        this.regNumber = regNumber;
        this.idCarFleet = idCarFleet;
    }

    public Car() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public int getIdCarFleet() {
        return idCarFleet;
    }

    public void setIdCarFleet(int idCarFleet) {
        this.idCarFleet = idCarFleet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return id == car.id && idCarFleet == car.idCarFleet && brandName.equals(car.brandName) && model.equals(car.model) && regNumber.equals(car.regNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brandName, model, regNumber, idCarFleet);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", model='" + model + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", idCarFleet=" + idCarFleet +
                '}';
    }
}
