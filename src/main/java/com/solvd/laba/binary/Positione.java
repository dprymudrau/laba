package com.solvd.laba.binary;

import java.util.Objects;

public class Positione extends BaseEntityID{

    private String positione;
    private int departmentNameID;
    private int departmentNameItCompaniesID;

    public String getPositione() {
        return positione;
    }
    public void setPositione(String positione) {
        this.positione = positione;
    }
    public int getDepartmentNameID() {
        return departmentNameID;
    }
    public void setDepartmentNameID(int departmentNameID) {
        this.departmentNameID = departmentNameID;
    }
    public int getDepartmentNameItCompaniesID() {
        return departmentNameItCompaniesID;
    }
    public void setDepartmentNameItCompaniesID(int departmentNameItCompaniesID) {
        this.departmentNameItCompaniesID = departmentNameItCompaniesID;
    }

    @Override
    public String toString() {
        String id = super.toString();
        return "Positione{" + id +
                ", positione='" + positione + '\'' +
                ", departmentNameID=" + departmentNameID +
                ", departmentNameItCompaniesID=" + departmentNameItCompaniesID +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Positione guest = (Positione) obj;
        boolean b = super.equals(obj) && (guest.positione == this.positione)&& (guest.departmentNameID == this.departmentNameID)&& (guest.departmentNameItCompaniesID == this.departmentNameItCompaniesID);
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), positione, departmentNameID, departmentNameItCompaniesID);
    }
}
