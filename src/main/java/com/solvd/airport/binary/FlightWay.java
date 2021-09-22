package com.solvd.airport.binary;

import java.util.Objects;

public class FlightWay {
    private long formAirportId;
    private long whereAirportId;
    private long companyId;

    public long getFormAirportId() {
        return formAirportId;
    }

    public void setFormAirportId(long formAirportId) {
        this.formAirportId = formAirportId;
    }

    public long getWhereAirportId() {
        return whereAirportId;
    }

    public void setWhereAirportId(long whereAirportId) {
        this.whereAirportId = whereAirportId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightWay flightWay = (FlightWay) o;
        return formAirportId == flightWay.formAirportId && whereAirportId == flightWay.whereAirportId && companyId == flightWay.companyId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(formAirportId, whereAirportId, companyId);
    }

    @Override
    public String toString() {
        return "FlightWay{" +
                "formAirportId=" + formAirportId +
                ", whereAirportId=" + whereAirportId +
                ", companyId=" + companyId +
                '}';
    }
}
