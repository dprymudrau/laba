package com.solvd.hospital.generics;

import com.solvd.hospital.head.PatientDatum;

import java.util.ArrayList;
import java.util.List;

public class PatientGeneric <T extends PatientDatum> {

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
