package com.solvd.laba.binary;

import java.util.Objects;

public class PhoneNumbers extends BaseEntityID{
    private String phoneNumbers;

    public String getPhoneNumbers() {
        return phoneNumbers;
    }
    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        String id = super.toString();

        return "PhoneNumbers{" + id +
                ", phoneNumbers='" + phoneNumbers + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        PhoneNumbers guest = (PhoneNumbers) obj;
        boolean b = super.equals(obj) && (guest.phoneNumbers == this.phoneNumbers);
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), phoneNumbers);
    }



}
