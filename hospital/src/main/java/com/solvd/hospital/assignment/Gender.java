package com.solvd.hospital.assignment;

public enum  Gender {

    MALE,
    FEMALE,
    UNKNOWN;

    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        return this.getName();
    }

    }

