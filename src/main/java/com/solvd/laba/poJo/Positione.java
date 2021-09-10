package com.solvd.laba.poJo;

import java.util.Objects;

public class Positione {
    private int id;
    private String positione;
    private int departmentNameID;
    private int departmentNameItCompaniesID;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
        return "Positione{" +
                "id=" + id +
                ", positione='" + positione + '\'' +
                ", departmentNameID=" + departmentNameID +
                ", departmentNameItCompaniesID=" + departmentNameItCompaniesID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positione positione1 = (Positione) o;
        return id == positione1.id && departmentNameID == positione1.departmentNameID && departmentNameItCompaniesID == positione1.departmentNameItCompaniesID && positione.equals(positione1.positione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, positione, departmentNameID, departmentNameItCompaniesID);
    }
}
