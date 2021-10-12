package com.solvd.laba.binary;

import java.util.Objects;

public class RegistrationCard {
    private int id;
    private int idHospital;
    private int idVisitor;
    private int idVisitorAgeGroupCategory;
    private int idVisitorCategory;

    public RegistrationCard(int id, int idHospital, int idVisitor, int idVisitorAgeGroupCategory, int idVisitorCategory) {
        this.id = id;
        this.idHospital = idHospital;
        this.idVisitor = idVisitor;
        this.idVisitorAgeGroupCategory = idVisitorAgeGroupCategory;
        this.idVisitorCategory = idVisitorCategory;
    }

    public RegistrationCard(int idVisitor, int idVisitorCategory) {
        this.idVisitor = idVisitor;
        this.idVisitorCategory = idVisitorCategory;
    }

    public RegistrationCard() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public int getIdVisitor() {
        return idVisitor;
    }

    public void setIdVisitor(int idVisitor) {
        this.idVisitor = idVisitor;
    }

    public int getIdVisitorAgeGroupCategory() {
        return idVisitorAgeGroupCategory;
    }

    public void setIdVisitorAgeGroupCategory(int idVisitorAgeGroupCategory) {
        this.idVisitorAgeGroupCategory = idVisitorAgeGroupCategory;
    }

    public int getIdVisitorCategory() {
        return idVisitorCategory;
    }

    public void setIdVisitorCategory(int idVisitorCategory) {
        this.idVisitorCategory = idVisitorCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegistrationCard)) return false;
        RegistrationCard that = (RegistrationCard) o;
        return id == that.id && idHospital == that.idHospital && idVisitor == that.idVisitor && idVisitorAgeGroupCategory == that.idVisitorAgeGroupCategory && idVisitorCategory == that.idVisitorCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idHospital, idVisitor, idVisitorAgeGroupCategory, idVisitorCategory);
    }

    @Override
    public String toString() {
        return "RegistrationCard{" +
                "id=" + id +
                ", idHospital=" + idHospital +
                ", idVisitor=" + idVisitor +
                ", idVisitorAgeGroupCategory=" + idVisitorAgeGroupCategory +
                ", idVisitorCategory=" + idVisitorCategory +
                '}';
    }
}
