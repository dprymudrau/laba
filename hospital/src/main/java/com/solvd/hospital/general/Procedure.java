package com.solvd.hospital.general;

import java.util.Date;


public class Procedure {
    // FIELDS
    private int idprocedure;
    private int iduser;
    private int procedureHowManyTimes;
    private String procedureName;
    private Date procedureStartDate;

    // CONSTRUCTORS
    public Procedure() {
    }
    public Procedure(int idprocedure, int iduser, int procedureHowManyTimes, String procedureName, Date procedureStartDate) {
        this.idprocedure = idprocedure;
        this.iduser = iduser;
        this.procedureHowManyTimes = procedureHowManyTimes;
        this.procedureName = procedureName;
        this.procedureStartDate = procedureStartDate;
    }

    public int getIdprocedure() {
        return idprocedure;
    }
    public void setIdprocedure(int idprocedure) {
        this.idprocedure = idprocedure;
    }

    public int getIduser() {
        return iduser;
    }
    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getProcedureHowManyTimes() {
        return procedureHowManyTimes;
    }
    public void setProcedureHowManyTimes(int procedureHowManyTimes) {
        this.procedureHowManyTimes = procedureHowManyTimes;
    }

    public String getProcedureName() {
        return procedureName;
    }
    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public Date getProcedureStartDate() {
        return procedureStartDate;
    }
    public void setProcedureStartDate(Date procedureStartDate) {
        this.procedureStartDate = procedureStartDate;
    }

    @Override
    public String toString() {
        return "Procedure{" +
                "idprocedure=" + idprocedure +
                ", iduser=" + iduser +
                ", procedureHowManyTimes=" + procedureHowManyTimes +
                ", procedureName='" + procedureName + '\'' +
                ", procedureStartDate=" + procedureStartDate +
                '}';
    }
}
