package com.solvd.laba.binary;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.Objects;

@XmlRootElement(name = "visitor")
@XmlType(propOrder = {"id", "name", "surname", "birthday", "address", "diagnosis", "visitDate", "dischargeDate"})
public class Visitor {
    @JsonProperty("patientID")
    private int id;
    @JsonProperty("patientName")
    private String name;
    @JsonProperty("patientSurname")
    private String surname;
    @JsonProperty("patientBirthday")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthday;
    @JsonProperty("patientAddress")
    private String address;
    @JsonProperty
    private String diagnosis;
    @JsonProperty
    private Date visitDate;
    @JsonProperty
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

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    @XmlElement(name = "surname")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    @XmlElement(name = "birthday")
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    @XmlElement(name = "address")
    public void setAddress(String address) {
        this.address = address;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @XmlElement(name = "diagnosis")
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    @XmlElement(name = "visitDate")
    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    @XmlElement(name = "dischargeDate")
    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visitor)) return false;
        Visitor visitor = (Visitor) o;
        return id == visitor.id && name.equals(visitor.name) && surname.equals(visitor.surname)
                && birthday.equals(visitor.birthday) && address.equals(visitor.address)
                && diagnosis.equals(visitor.diagnosis) && visitDate.equals(visitor.visitDate);
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
