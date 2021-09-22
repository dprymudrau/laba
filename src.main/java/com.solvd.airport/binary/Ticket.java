package com.solvd.airport.binary;

import java.sql.Date;
import java.util.Objects;

public class Ticket {

    private long idTicket;
    private long passengerId;
    private long flightId;
    private int placeNumber;
    private Date dateOfBuying;

    public long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(long id) {
        this.idTicket = id;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long id) {
        this.passengerId = id;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long id) {
        this.flightId = id;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int num) {
        this.placeNumber = num;
    }

    public Date getDateOfBuying() {
        return dateOfBuying;
    }

    public void setDateOfBuying(Date date) {
        dateOfBuying = date;
    }

    @Override
    public String toString() {
        return idTicket + ":" + passengerId + ":" + flightId + ":" + placeNumber + ":" + dateOfBuying.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Ticket guest = (Ticket) obj;
        return super.equals(obj) && (this.idTicket == guest.idTicket) && (this.passengerId == guest.passengerId) && (this.flightId == guest.flightId) && (this.placeNumber == guest.placeNumber) && (this.dateOfBuying.equals((guest.dateOfBuying)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idTicket, passengerId, flightId, placeNumber, dateOfBuying);
    }
}
