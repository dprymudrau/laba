package com.solvd.laba.binary;

import java.sql.Date;
import java.util.Objects;

public class DriverLicense {
    private int licenseNumber;
    private String driverCategory;
    private int idCar;
    private int idDriver;
    private Date issueDate;
    private Date expirationDate;

    public DriverLicense(int licenseNumber, String driverCategory, int idCar, int idDriver, Date issueDate, Date expirationDate) {
        this.licenseNumber = licenseNumber;
        this.driverCategory = driverCategory;
        this.idCar = idCar;
        this.idDriver = idDriver;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
    }

    public DriverLicense() {}

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getDriverCategory() {
        return driverCategory;
    }

    public void setDriverCategory(String driverCategory) {
        this.driverCategory = driverCategory;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DriverLicense)) return false;
        DriverLicense that = (DriverLicense) o;
        return licenseNumber == that.licenseNumber && idCar == that.idCar && idDriver == that.idDriver && driverCategory.equals(that.driverCategory) && issueDate.equals(that.issueDate) && expirationDate.equals(that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenseNumber, driverCategory, idCar, idDriver, issueDate, expirationDate);
    }

    @Override
    public String toString() {
        return "DriverLicense{" +
                "licenseNumber=" + licenseNumber +
                ", driverCategory='" + driverCategory + '\'' +
                ", idCar=" + idCar +
                ", idDriver=" + idDriver +
                ", issueDate=" + issueDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
