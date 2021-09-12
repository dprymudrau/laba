package com.solvd.laba.poJo;

import java.util.Objects;

public class Emploee extends BaseEntityID{
    private String cCName;
    private String cCSurname;
    private String cCPatronymic;
    private int positioneID;
    private int projectID;

    public String getcCName() {
        return cCName;
    }
    public void setcCName(String cCName) {
        this.cCName = cCName;
    }
    public String getcCSurname() {
        return cCSurname;
    }
    public void setcCSurname(String cCSurname) {
        this.cCSurname = cCSurname;
    }
    public String getcCPatronymic() {
        return cCPatronymic;
    }
    public void setcCPatronymic(String cCPatronymic) {
        this.cCPatronymic = cCPatronymic;
    }
    public int getPositioneID() {
        return positioneID;
    }
    public void setPositioneID(int positioneID) {
        this.positioneID = positioneID;
    }
    public int getProjectID() {
        return projectID;
    }
    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    @Override
    public String toString() {
        String id = super.toString();
        return "Emploee{" + id +
                ", cCName='" + cCName + '\'' +
                ", cCSurname='" + cCSurname + '\'' +
                ", cCPatronymic='" + cCPatronymic + '\'' +
                ", positioneID=" + positioneID +
                ", projectID=" + projectID +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Emploee guest = (Emploee) obj;
        boolean b = super.equals(obj) && (guest.cCName == this.cCName)&& (guest.cCSurname == this.cCSurname)&& (guest.cCPatronymic == this.cCPatronymic)&& (guest.positioneID == this.positioneID)&& (guest.projectID == this.projectID);
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cCName, cCSurname, cCPatronymic, positioneID, projectID);
    }
}
