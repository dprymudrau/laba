package com.solvd.airport.binary;

import java.util.Objects;

public class PilotCategory {

    private long idPilotCategory;
    private String pilotCategoryName;

    public long getIdPilotCategory() {
        return idPilotCategory;
    }

    public void setIdPilotCategory(long idPilotCategory) {
        this.idPilotCategory = idPilotCategory;
    }

    public String getPilotCategoryName() {
        return pilotCategoryName;
    }

    public void setPilotCategoryName(String pilotCategoryName) {
        this.pilotCategoryName = pilotCategoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PilotCategory that = (PilotCategory) o;
        return idPilotCategory == that.idPilotCategory && pilotCategoryName.equals(that.pilotCategoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPilotCategory, pilotCategoryName);
    }

    @Override
    public String toString() {
        return "PilotCategory{" +
                "idPilotCategory=" + idPilotCategory +
                ", pilotCategoryName='" + pilotCategoryName + '\'' +
                '}';
    }
}
