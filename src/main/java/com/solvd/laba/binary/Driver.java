package com.solvd.laba.binary;

import java.sql.Date;
import java.util.Objects;

public class Driver {
    private int id;
    private String name;
    private String surname;
    private Date birthday;
    private int idWorkPosition;
    private int idNumberOfContract;
    private int idWorkExp;

    public Driver(int id, String name, String surname, Date birthday, int idWorkPosition, int idNumberOfContract, int idWorkExp) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.idWorkPosition = idWorkPosition;
        this.idNumberOfContract = idNumberOfContract;
        this.idWorkExp = idWorkExp;
    }

    public Driver() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getIdWorkPosition() {
        return idWorkPosition;
    }

    public void setIdWorkPosition(int idWorkPosition) {
        this.idWorkPosition = idWorkPosition;
    }

    public int getIdNumberOfContract() {
        return idNumberOfContract;
    }

    public void setIdNumberOfContract(int idNumberOfContract) {
        this.idNumberOfContract = idNumberOfContract;
    }

    public int getIdWorkExp() {
        return idWorkExp;
    }

    public void setIdWorkExp(int idWorkExp) {
        this.idWorkExp = idWorkExp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver driver = (Driver) o;
        return id == driver.id && idWorkPosition == driver.idWorkPosition && idNumberOfContract == driver.idNumberOfContract && idWorkExp == driver.idWorkExp && name.equals(driver.name) && surname.equals(driver.surname) && birthday.equals(driver.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, birthday, idWorkPosition, idNumberOfContract, idWorkExp);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", idWorkPosition=" + idWorkPosition +
                ", idNumberOfContract=" + idNumberOfContract +
                ", idWorkExp=" + idWorkExp +
                '}';
    }
}
