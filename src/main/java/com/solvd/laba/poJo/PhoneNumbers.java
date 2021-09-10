package com.solvd.laba.poJo;

import java.util.Objects;

public class PhoneNumbers {
    private int id;
    private String phoneNumbers;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPhoneNumbers() {
        return phoneNumbers;
    }
    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumbers that = (PhoneNumbers) o;
        return id == that.id && phoneNumbers.equals(that.phoneNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phoneNumbers);
    }

    @Override
    public String toString() {
        return "PhoneNumbers{" +
                "id=" + id +
                ", phoneNumbers='" + phoneNumbers + '\'' +
                '}';
    }

}
