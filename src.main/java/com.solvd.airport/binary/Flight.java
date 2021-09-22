package com.solvd.airport.binary;

import java.sql.Date;
import java.util.Objects;

public class Flight {

    private long idFlight;
    private long pilotId;
    private long planeId;
    private long flightWayId;
    private long categoryId;
    private int price;
    private Date flightDate;

    public long getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(long idFlight) {
        this.idFlight = idFlight;
    }

    public long getPilotId() {
        return pilotId;
    }

    public void setPilotId(long pilotId) {
        this.pilotId = pilotId;
    }

    public long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(long planeId) {
        this.planeId = planeId;
    }

    public long getFlightWayId() {
        return flightWayId;
    }

    public void setFlightWayId(long flightWayId) {
        this.flightWayId = flightWayId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
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
        return idFlight == flight.idFlight && pilotId == flight.pilotId && planeId == flight.planeId && flightWayId == flight.flightWayId && categoryId == flight.categoryId && price == flight.price && flightDate.equals(flight.flightDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFlight, pilotId, planeId, flightWayId, categoryId, price, flightDate);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "idFlight=" + idFlight +
                ", pilotId=" + pilotId +
                ", planeId=" + planeId +
                ", flightWayId=" + flightWayId +
                ", categoryId=" + categoryId +
                ", price=" + price +
                ", flightDate=" + flightDate +
                '}';
    }
}
