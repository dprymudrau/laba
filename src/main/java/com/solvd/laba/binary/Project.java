package com.solvd.laba.binary;

import java.util.Objects;

public class Project extends BaseEntityID{

    private String project;
    private int departmentNameId ;
    private int departmentNameIdItCompaniesID;

    public String getProject() {
        return project;
    }
    public void setProject(String project) {
        this.project = project;
    }
    public int getDepartmentNameId() {
        return departmentNameId;
    }
    public void setDepartmentNameId(int departmentNameId) {
        this.departmentNameId = departmentNameId;
    }
    public int getDepartmentNameIdItCompaniesID() {
        return departmentNameIdItCompaniesID;
    }
    public void setDepartmentNameIdItCompaniesID(int departmentNameIdItCompaniesID) {
        this.departmentNameIdItCompaniesID = departmentNameIdItCompaniesID;
    }

    @Override
    public String toString() {
        String id = super.toString();
        return "Project{" + id +
                ", project='" + project + '\'' +
                ", departmentNameId=" + departmentNameId +
                ", departmentNameIdItCompaniesID=" + departmentNameIdItCompaniesID +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Project guest = (Project) obj;
        boolean b = super.equals(obj) && (guest.project == this.project)&& (guest.departmentNameId == this.departmentNameId)&& (guest.departmentNameIdItCompaniesID == this.departmentNameIdItCompaniesID);
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), project, departmentNameId, departmentNameIdItCompaniesID);
    }
}
