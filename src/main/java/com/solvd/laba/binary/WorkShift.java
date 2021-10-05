package com.solvd.laba.binary;

import java.sql.Time;
import java.util.Objects;

public class WorkShift {
    private int id;
    private String name;
    private Time clockIn;
    private Time clockOut;
    private int idHospital;

    public WorkShift(int id, String name, Time clockIn, Time clockOut, int idHospital) {
        this.id = id;
        this.name = name;
        this.clockIn = clockIn;
        this.clockOut = clockOut;
        this.idHospital = idHospital;
    }

    public WorkShift() {}

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

    public Time getClockIn() {
        return clockIn;
    }

    public void setClockIn(Time clockIn) {
        this.clockIn = clockIn;
    }

    public Time getClockOut() {
        return clockOut;
    }

    public void setClockOut(Time clockOut) {
        this.clockOut = clockOut;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkShift)) return false;
        WorkShift workShift = (WorkShift) o;
        return id == workShift.id && idHospital == workShift.idHospital && name.equals(workShift.name) && clockIn.equals(workShift.clockIn) && clockOut.equals(workShift.clockOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, clockIn, clockOut, idHospital);
    }

    @Override
    public String toString() {
        return "WorkShift{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clockIn=" + clockIn +
                ", clockOut=" + clockOut +
                ", idHospital=" + idHospital +
                '}';
    }
}
