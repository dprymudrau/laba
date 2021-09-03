package com.solvd.hospital.general;

public class Status {

    private int idstatus;
    private String statusName;

    public Status() {
    }
    public Status(int idstatus, String statusName) {
        this.idstatus = idstatus;
        this.statusName = statusName;
    }

    public int getIdstatus() {
        return idstatus;
    }
    public void setIdstatus(int idstatus) {
        this.idstatus = idstatus;
    }

    public String getStatusName() {
        return statusName;
    }
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "Status{" +
                "idstatus=" + idstatus +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
