package com.solvd.laba.poJo;

import java.util.Objects;

public class ITCompanies {
    private int id;
    private String companiName;
    private int adressID;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCompaniName() {
        return companiName;
    }
    public void setCompaniName(String companiName) {
        this.companiName = companiName;
    }
    public int getAdressID() {
        return adressID;
    }
    public void setAdressID(int adressID) {
        this.adressID = adressID;
    }

    @Override
    public String toString() {
        return "ITCompanies{" +
                "id=" + id +
                ", companiName='" + companiName + '\'' +
                ", adressID=" + adressID +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ITCompanies that = (ITCompanies) o;
        return id == that.id && adressID == that.adressID && companiName.equals(that.companiName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companiName, adressID);
    }
}
