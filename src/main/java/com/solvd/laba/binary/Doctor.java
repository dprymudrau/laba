package com.solvd.laba.binary;

import java.sql.Date;
import java.util.Objects;

public class Doctor {
    private int id;
    private String name;
    private String surname;
    private Date birthday;
    private int idWorkPosition;
    private int idSpeciality;
    private int idNumberOdContract;
    private int idWorkExp;

    public Doctor(int id, String name, String surname, Date birthday,
                  int idWorkPosition, int idSpeciality, int idNumberOdContract, int idWorkExp) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.idWorkPosition = idWorkPosition;
        this.idSpeciality = idSpeciality;
        this.idNumberOdContract = idNumberOdContract;
        this.idWorkExp = idWorkExp;
    }

    public Doctor() {}

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

    public int getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(int idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public int getIdNumberOdContract() {
        return idNumberOdContract;
    }

    public void setIdNumberOdContract(int idNumberOdContract) {
        this.idNumberOdContract = idNumberOdContract;
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
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id && idWorkPosition == doctor.idWorkPosition && idSpeciality == doctor.idSpeciality
                && idNumberOdContract == doctor.idNumberOdContract && idWorkExp == doctor.idWorkExp
                && name.equals(doctor.name) && surname.equals(doctor.surname) && birthday.equals(doctor.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, birthday, idWorkPosition,
                idSpeciality, idNumberOdContract, idWorkExp);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", idWorkPosition=" + idWorkPosition +
                ", idSpeciality=" + idSpeciality +
                ", idNumberOdContract=" + idNumberOdContract +
                ", idWorkExp=" + idWorkExp +
                '}';
    }
}
