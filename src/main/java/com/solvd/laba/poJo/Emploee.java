package com.solvd.laba.poJo;

import java.util.Objects;

public class Emploee {
    private int id;
    private String cCName;
    private String cCSurname;
    private String cCPatronymic;
    private int positioneID;
    private int projectID;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
        return "Emploee{" +
                "id=" + id +
                ", cCName='" + cCName + '\'' +
                ", cCSurname='" + cCSurname + '\'' +
                ", cCPatronymic='" + cCPatronymic + '\'' +
                ", positioneID=" + positioneID +
                ", projectID=" + projectID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emploee emploee = (Emploee) o;
        return id == emploee.id && positioneID == emploee.positioneID && projectID == emploee.projectID && cCName.equals(emploee.cCName) && cCSurname.equals(emploee.cCSurname) && cCPatronymic.equals(emploee.cCPatronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cCName, cCSurname, cCPatronymic, positioneID, projectID);
    }
}
