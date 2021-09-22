package com.solvd.airport.binary;

import java.util.Objects;

public class PassengerAccount {

    private long idPassengerAccount;
    private String passportNumber;
    private String fullName;

    public long getIdPassengerAccount() {
        return idPassengerAccount;
    }

    public void setIdPassengerAccount(long id) {
        idPassengerAccount = id;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String number) {
        passportNumber = number;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String name) {
        fullName = name;
    }

    @Override
    public String toString() {
        return idPassengerAccount + ":" + fullName + ":" + passportNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        PassengerAccount guest = (PassengerAccount) obj;
        return super.equals(obj) && (guest.passportNumber.equals(this.passportNumber)) && (guest.fullName.equals(this.fullName)) && (guest.idPassengerAccount == this.idPassengerAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fullName, passportNumber, idPassengerAccount);
    }
}
