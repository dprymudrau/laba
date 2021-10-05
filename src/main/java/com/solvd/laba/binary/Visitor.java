package com.solvd.laba.binary;

import java.sql.Date;
import java.util.Objects;

public class Visitor {
    private int id;
    private String name;
    private String surname;
    private Date birthday;
    private String address;
    private String diagnosis;
    private Date visitDate;
    private Date dischargeDate;

    public Visitor(int id, String name, String surname, Date birthday,
                   String address, String diagnosis, Date visitDate, Date dischargeDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.address = address;
        this.diagnosis = diagnosis;
        this.visitDate = visitDate;
        this.dischargeDate = dischargeDate;
    }

    public Visitor() {}

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visitor)) return false;
        Visitor visitor = (Visitor) o;
        return id == visitor.id && name.equals(visitor.name) && surname.equals(visitor.surname) && birthday.equals(visitor.birthday) && address.equals(visitor.address) && diagnosis.equals(visitor.diagnosis) && visitDate.equals(visitor.visitDate) && dischargeDate.equals(visitor.dischargeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, birthday, address, diagnosis, visitDate, dischargeDate);
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", visitDate=" + visitDate +
                ", dischargeDate=" + dischargeDate +
                '}';
    }
}
