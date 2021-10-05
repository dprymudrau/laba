package com.solvd.laba.binary;

import java.util.Objects;

public class Speciality {
    private int id;
    private String specialityName;

    public Speciality(int id, String specialityName) {
        this.id = id;
        this.specialityName = specialityName;
    }

    public Speciality() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Speciality)) return false;
        Speciality that = (Speciality) o;
        return id == that.id && specialityName.equals(that.specialityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, specialityName);
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "id=" + id +
                ", specialityName='" + specialityName + '\'' +
                '}';
    }
}
