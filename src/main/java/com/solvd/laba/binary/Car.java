package com.solvd.laba.binary;

import com.solvd.laba.utils.parsers.jaxb.DateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.Objects;

@XmlRootElement(name = "car")
@XmlType(propOrder = { "carId", "carName", "numberOfTheCar", "carTypeId","dateOfConstruct", "taxiCompaniesId" })
public class Car {
    private int carId;
    private String carName;
    private int numberOfTheCar;
    private int carTypeId;
    private Date dateOfConstruct;
    private int taxiCompaniesId;



    public Date getDateOfConstruct() {
        return dateOfConstruct;
    }

    public int getNumberOfTheCar() {
        return numberOfTheCar;
    }

    public void setNumberOfTheCar(int numberOfTheCar) {
        this.numberOfTheCar = numberOfTheCar;
    }

    public int getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(int carTypeId) {
        this.carTypeId = carTypeId;
    }

    public int getTaxiCompaniesId() {
        return taxiCompaniesId;
    }

    public void setTaxiCompaniesId(int taxiCompaniesId) {
        this.taxiCompaniesId = taxiCompaniesId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @XmlElement(name = "carName")
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
