package com.solvd.laba.binary;

import java.util.Objects;

public class Hospital {
    private int id;
    private String name;
    private String address;
    private int idCarFleet;

    public Hospital(int id, String name, String address, int idCarFleet) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.idCarFleet = idCarFleet;
    }

    public Hospital() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdCarFleet() {
        return idCarFleet;
    }

    public void setIdCarFleet(int idCarFleet) {
        this.idCarFleet = idCarFleet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hospital)) return false;
        Hospital hospital = (Hospital) o;
        return id == hospital.id && idCarFleet == hospital.idCarFleet && name.equals(hospital.name) && address.equals(hospital.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, idCarFleet);
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", idCarFleet=" + idCarFleet +
                '}';
    }
}
