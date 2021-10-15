package com.solvd.laba.utils.parsers.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.Objects;

@XmlRootElement(name = "car")
@XmlType(propOrder = { "id", "name", "date" })
public class Car {
    private int carId;
    private String carName;
    private Date dateOfConstruct;

    public int getTaxiCompaniesId() {
        return taxiCompaniesId;
    }

    public void setTaxiCompaniesId(int taxiCompaniesId) {
        this.taxiCompaniesId = taxiCompaniesId;
    }

    private int taxiCompaniesId;

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @XmlElement(name = "name")
    public void setCarName(String carName) {
        this.carName = carName;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDateOfConstruct(Date dateOfConstruct) {
        this.dateOfConstruct = dateOfConstruct;
    }

    public int getCarId() {
        return carId;
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carId == car.carId && Objects.equals(carName, car.carName) && Objects.equals(dateOfConstruct, car.dateOfConstruct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, carName, dateOfConstruct);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                ", dateOfConstruct=" + dateOfConstruct +
                '}';
    }

}
