package com.solvd.airport.utils.SaxParser;

public class Passenger {

    private int idPassenger;
    private String passengerName;
    private String phoneNumber;
    private int accountId;

    public int getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(int id) {
        idPassenger = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String name) {
        passengerName = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String number) {
        phoneNumber = number;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int id) {
        accountId = id;
    }

    @Override
    public String toString(){
        return idPassenger+":"+passengerName+":"+phoneNumber+":"+accountId;
    }
}
