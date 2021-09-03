package com.solvd.hospital.general;

public class Pills {

    // FIELDS
    private int idpill;
    private int iduser;
    private String pillName;
    private String pillDesc;
    private String pillDosing;

    // CONSTRUCTORS
    public Pills(int idpill, int iduser, String pillName, String pillDesc, String pillDosing) {
        this.idpill = idpill;
        this.iduser = iduser;
        this.pillName = pillName;
        this.pillDesc = pillDesc;
        this.pillDosing = pillDosing;
    }
    public Pills() {
    }

    public int getIdpill() {
        return idpill;
    }
    public void setIdpill(int idpill) {
        this.idpill = idpill;
    }

    public int getIduser() {
        return iduser;
    }
    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getPillName() {
        return pillName;
    }
    public void setPillName(String pillName) {
        this.pillName = pillName;
    }

    public String getpillDesc() {
        return pillDesc;
    }
    public void setPillDesc(String pillDesc) {
        this.pillDesc = pillDesc;
    }

    public String getPillDosing() {
        return pillDosing;
    }
    public void setPillDosing(String PillDosing) {
        this.pillDosing = pillDosing;
    }

    @Override
    public String toString() {
        return "Pill{" +
                "idpill=" + idpill +
                ", iduser=" + iduser +
                ", pillName='" + pillName + '\'' +
                ", pillDesc='" + pillDesc + '\'' +
                ", pillDosing='" + pillDosing + '\'' +
                '}';
    }
}
