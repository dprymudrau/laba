package com.solvd.airport.binary;

import javax.xml.bind.annotation.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "ticket")
@XmlType(propOrder = {"passengerId", "placeNumber","passenger","someIds"})
public class Ticket {

    private long idTicket;
    private long passengerId;
    private long flightId;
    private int placeNumber;
    private Date dateOfBuying /*= Date.valueOf(LocalDate.EPOCH)*/;
    private List someIds;
    private Passenger passenger;

    @XmlAttribute(name="idTicket")
    public long getIdTicket() {
        return idTicket;
    }

    @XmlElement(name = "passengerId")
    public long getPassengerId() {
        return passengerId;
    }

    @XmlElement(name="placeNumber")
    public int getPlaceNumber() {
        return placeNumber;
    }

    /*@XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement(name="dateOfBuying")*/
    @XmlTransient
    public Date getDateOfBuying() {
        return dateOfBuying;
    }

    @XmlElement(name = "passenger")
    public Passenger getPassenger() {
        return passenger;
    }

    @XmlElementWrapper(name="someIds")
    @XmlElement(name = "id")
    public List getSomeIds() {
        return someIds;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setSomeIds(List someIds) {
        this.someIds = someIds;
    }

    public void setIdTicket(long id) {
        this.idTicket = id;
    }

    public void setPassengerId(long id) {
        this.passengerId = id;
    }
    @XmlTransient
    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long id) {
        this.flightId = id;
    }

    public void setPlaceNumber(int num) {
        this.placeNumber = num;
    }

    public void setDateOfBuying(Date date) {
        this.dateOfBuying = date;
    }

    @Override
    public String toString() {
        return idTicket + ":" + passengerId + ":" /*+ flightId + ":" */+ placeNumber + ":" /*+ dateOfBuying.toString()+":"*/+someIds.toString() +":"+passenger.toString();
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
