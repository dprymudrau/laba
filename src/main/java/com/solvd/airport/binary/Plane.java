package com.solvd.airport.binary;

import java.util.Objects;

public class Plane {
    private long idPlane;
    private long companyId;
    private long modelId;
    private String serialNumber;

    public long getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(long idPlane) {
        this.idPlane = idPlane;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public long getModelId() {
        return modelId;
    }

    public void setModelId(long modelId) {
        this.modelId = modelId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return companyId == plane.companyId && modelId == plane.modelId && serialNumber.equals(plane.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, modelId, serialNumber);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "companyId=" + companyId +
                ", modelId=" + modelId +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
