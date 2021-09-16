package com.solvd.laba.binary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class ITCompanies extends BaseEntityID{
    private static final Logger LOGGER = LogManager.getLogger(ITCompanies.class);
    private String companiName;
    private int adressID;


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
        String id = super.toString();
        return "ITCompanies{" + id +
                ", companiName='" + companiName + '\'' +
                ", adressID=" + adressID +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        ITCompanies guest = (ITCompanies) obj;
        boolean b = super.equals(obj) && (guest.companiName == this.companiName)&& (guest.adressID == this.adressID);
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), companiName, adressID);
    }
}
