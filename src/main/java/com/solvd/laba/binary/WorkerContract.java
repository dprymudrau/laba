package com.solvd.laba.binary;

import java.sql.Date;
import java.util.Objects;

public class WorkerContract {
    private int id;
    private int idHospital;
    private Date dateOfSigning;

    public WorkerContract(int id, int idHospital, Date dateOfSigning) {
        this.id = id;
        this.idHospital = idHospital;
        this.dateOfSigning = dateOfSigning;
    }

    public WorkerContract() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public Date getDateOfSigning() {
        return dateOfSigning;
    }

    public void setDateOfSigning(Date dateOfSigning) {
        this.dateOfSigning = dateOfSigning;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkerContract)) return false;
        WorkerContract that = (WorkerContract) o;
        return id == that.id && idHospital == that.idHospital && dateOfSigning.equals(that.dateOfSigning);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idHospital, dateOfSigning);
    }

    @Override
    public String toString() {
        return "WorkerContract{" +
                "id=" + id +
                ", idHospital=" + idHospital +
                ", dateOfSigning=" + dateOfSigning +
                '}';
    }
}
