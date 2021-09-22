package com.solvd.airport.binary;

import java.util.Objects;

public class FlightCategory {

    private long idFlightCategory;
    private String flightCategoryName;

    public long getIdFlightCategory() {
        return idFlightCategory;
    }

    public void setIdFlightCategory(long idFlightCategory) {
        this.idFlightCategory = idFlightCategory;
    }

    public String getFlightCategoryName() {
        return flightCategoryName;
    }

    public void setFlightCategoryName(String flightCategoryName) {
        this.flightCategoryName = flightCategoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightCategory that = (FlightCategory) o;
        return idFlightCategory == that.idFlightCategory && flightCategoryName.equals(that.flightCategoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFlightCategory, flightCategoryName);
    }

    @Override
    public String toString() {
        return "FlightCategory{" +
                "idFlightCategory=" + idFlightCategory +
                ", flightCategoryName='" + flightCategoryName + '\'' +
                '}';
    }
}
