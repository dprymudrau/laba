package com.solvd.airport.utils.SaxParser;

public class PassengerAccount {

    private int idPassengerAccount;
    private String passportNumber;
    private String fullName;

    public int getIdPassengerAccount() {
        return idPassengerAccount;
    }

    public void setIdPassengerAccount(int id) {
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
    public String toString(){
        return idPassengerAccount+":"+fullName+":"+passportNumber;
    }
}
