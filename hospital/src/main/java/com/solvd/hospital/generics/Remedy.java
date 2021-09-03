package com.solvd.hospital.generics;

import com.solvd.hospital.general.Pills;

import java.util.ArrayList;
import java.util.List;

public class Remedy <T extends Pills> {

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
