package com.solvd.laba.binary;

import java.util.Objects;

public class Bank {
    private String name;
    private int phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return phoneNumber == bank.phoneNumber && Objects.equals(name, bank.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }
}
