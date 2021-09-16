package com.solvd.laba.binary;

import java.util.Objects;

public class Сustomer extends BaseEntityID{
    private String custumer;
    private int adressID;

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
        String id = super.toString();
        return "Сustomer{" + id +
                ", custumer='" + custumer + '\'' +
                ", adressID=" + adressID +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Сustomer guest = (Сustomer) obj;
        boolean b = super.equals(obj) && (guest.custumer == this.custumer)&& (guest.adressID == this.adressID);
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), custumer, adressID);
    }



}
