package com.solvd.laba.poJo;

import java.util.Objects;

public class Adress {
    private int id;
    private String adress;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public String getAdress() {
        return adress;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", adress='" + adress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adress adress1 = (Adress) o;
        return id == adress1.id && adress.equals(adress1.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, adress);
    }
}
