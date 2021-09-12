package com.solvd.laba.poJo;

import java.util.Objects;

public class Adress extends BaseEntityID{
    private String adress;

    public void setAdress(String adress) {
        this.adress = adress;
    }
    public String getAdress() {
        return adress;
    }

    @Override
    public String toString() {
        String id = super.toString();
        return "Adress{" + id +
                ", adress='" + adress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Adress guest = (Adress) obj;
        boolean b = super.equals(obj) && (guest.adress == this.adress);
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), adress);
    }
}
