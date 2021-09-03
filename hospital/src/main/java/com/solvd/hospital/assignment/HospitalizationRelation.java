package com.solvd.hospital.assignment;


public enum HospitalizationRelation {
    FIRST("Emergency hospitalization"),
    SECOND("Hospital waiting");

    private String itemName;

    HospitalizationRelation(String itemName) {
        this.itemName = itemName;
    }
    public String getHospitalization(){
        return this.itemName;
    }
}
