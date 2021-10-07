package com.solvd.airport.binary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Objects;
@JsonIgnoreProperties(value = { "countryId" })

public class Town {
    @JsonProperty("id")
    private long idTown;
    private long countryId;
    @JsonProperty("name")
    private String townName;
    @JsonProperty("airports")
    private ArrayList<Airport> airports;

    public ArrayList<Airport> getAirports() {
        return airports;
    }

    public void setAirports(ArrayList<Airport> airports) {
        this.airports = airports;
    }

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
                ", airports=" + airports +
                '}';
    }
}
