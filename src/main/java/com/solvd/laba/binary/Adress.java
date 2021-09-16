package com.solvd.laba.binary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Adress extends BaseEntityID{
    private static final Logger LOGGER = LogManager.getLogger(Adress.class);
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
