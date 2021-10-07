package com.solvd.airport.binary;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement(name = "passenger")
@XmlType(propOrder = {"idPassenger", "passengerName"})
public class Passenger {

    private long idPassenger;
    private String passengerName;
    private String phoneNumber;

    @XmlAttribute(name="id")
    public long getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(long id) {
        idPassenger = id;
    }

    @XmlElement(name="name")
    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String name) {
        passengerName = name;
    }

    @XmlTransient
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String number) {
        phoneNumber = number;
    }

    @Override
    public String toString() {
        return idPassenger + ":" + passengerName + ":" + phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Passenger guest = (Passenger) obj;
        return super.equals(obj) && (guest.passengerName.equals(this.passengerName)) && (guest.phoneNumber.equals(this.phoneNumber)) && (guest.idPassenger == this.idPassenger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengerName, phoneNumber, idPassenger);
    }
}
