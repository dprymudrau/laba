package com.solvd.airport.binary;

import java.sql.Date;
import java.util.Objects;

public class Flight {

    private long idFlight;
    private long planeId;
    private long categoryId;
    private long fromAirportId;
    private long whereAirportId;
    private int price;
    private Date flightDate;

    public long getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(long idFlight) {
        this.idFlight = idFlight;
    }

    public long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(long planeId) {
        this.planeId = planeId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getFromAirportId() {
        return fromAirportId;
    }

    public void setFromAirportId(long fromAirportId) {
        this.fromAirportId = fromAirportId;
    }

    public long getWhereAirportId() {
        return whereAirportId;
    }

    public void setWhereAirportId(long whereAirportId) {
        this.whereAirportId = whereAirportId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return idFlight == flight.idFlight && planeId == flight.planeId && categoryId == flight.categoryId && fromAirportId == flight.fromAirportId && whereAirportId == flight.whereAirportId && price == flight.price && flightDate.equals(flight.flightDate);
    }

    @Override       
    public int hashCode() {
        return Objects.hash(idFlight, planeId, categoryId, fromAirportId, whereAirportId, price, flightDate);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "idFlight=" + idFlight +
                ", planeId=" + planeId +
                ", categoryId=" + categoryId +
                ", fromAirportId=" + fromAirportId +
                ", whereAirportId=" + whereAirportId +
                ", price=" + price +
                ", flightDate=" + flightDate +
                '}';
    }
}
