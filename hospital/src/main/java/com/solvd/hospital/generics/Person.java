package com.solvd.hospital.generics;

import com.solvd.hospital.people.PersonHospital;

import java.util.ArrayList;
import java.util.List;

public class Person <T extends PersonHospital> {

    private T t;
    private List<T> patient = new ArrayList<>();

    public List<T> getPatientDatum() {
        return patient;
    }

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
