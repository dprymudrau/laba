package com.solvd.airport.binary;

import java.util.Objects;

public class PlaneModel {
    private long idPlaneModel;
    private  int capacity;
    private String planeModelName;

    public long getIdPlaneModel() {
        return idPlaneModel;
    }

    public void setIdPlaneModel(long idPlaneModel) {
        this.idPlaneModel = idPlaneModel;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPlaneModelName() {
        return planeModelName;
    }

    public void setPlaneModelName(String planeModelName) {
        this.planeModelName = planeModelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaneModel that = (PlaneModel) o;
        return idPlaneModel == that.idPlaneModel && capacity == that.capacity && planeModelName.equals(that.planeModelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlaneModel, capacity, planeModelName);
    }

    @Override
    public String toString() {
        return "PlaneModel{" +
                "idPlaneModel=" + idPlaneModel +
                ", capacity=" + capacity +
                ", planeModelName='" + planeModelName + '\'' +
                '}';
    }
}
