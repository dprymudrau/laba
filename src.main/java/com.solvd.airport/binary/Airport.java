package com.solvd.airport.binary;

import java.util.Objects;

public class Airport {
    private long idAirport;
    private long townId;
    private String airportName;
    private int passengersPerDay;

    public long getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(long idAirport) {
        this.idAirport = idAirport;
    }

    public long getTownId() {
        return townId;
    }

    public void setTownId(long townId) {
        this.townId = townId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public int getPassengersPerDay() {
        return passengersPerDay;
    }

    public void setPassengersPerDay(int passengersPerDay) {
        this.passengersPerDay = passengersPerDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return idAirport == airport.idAirport && townId == airport.townId && passengersPerDay == airport.passengersPerDay && Objects.equals(airportName, airport.airportName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAirport, townId, airportName, passengersPerDay);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "idAirport=" + idAirport +
                ", townId=" + townId +
                ", airportName='" + airportName + '\'' +
                ", passengersPerDay=" + passengersPerDay +
                '}';
    }
}
