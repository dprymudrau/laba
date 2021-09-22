package com.solvd.airport.binary;

import java.util.Objects;

public class Town {

    private long idTown;
    private long countryId;
    private String townName;

    public long getIdTown() {
        return idTown;
    }

    public void setIdTown(long idTown) {
        this.idTown = idTown;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Town town = (Town) o;
        return idTown == town.idTown && countryId == town.countryId && townName.equals(town.townName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTown, countryId, townName);
    }

    @Override
    public String toString() {
        return "Town{" +
                "idTown=" + idTown +
                ", countryId=" + countryId +
                ", townName='" + townName + '\'' +
                '}';
    }
}
