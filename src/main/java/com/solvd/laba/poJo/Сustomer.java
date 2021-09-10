package com.solvd.laba.poJo;

import java.util.Objects;

public class Сustomer {
    private int id;
    private String custumer;
    private int adressID;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCustumer() {
        return custumer;
    }
    public void setCustumer(String custumer) {
        this.custumer = custumer;
    }
    public int getAdressID() {
        return adressID;
    }
    public void setAdressID(int adressID) {
        this.adressID = adressID;
    }

    @Override
    public String toString() {
        return "Сustomer{" +
                "id=" + id +
                ", custumer='" + custumer + '\'' +
                ", adressID=" + adressID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Сustomer сustomer = (Сustomer) o;
        return id == сustomer.id && adressID == сustomer.adressID && custumer.equals(сustomer.custumer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, custumer, adressID);
    }



}
