package com.solvd.laba.poJo;

import java.util.Objects;

public class Project {
    private int id;
    private String project;
    private int departmentNameId ;
    private int departmentNameIdItCompaniesID;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
        return "Project{" +
                "id=" + id +
                ", project='" + project + '\'' +
                ", departmentNameId=" + departmentNameId +
                ", departmentNameIdItCompaniesID=" + departmentNameIdItCompaniesID +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project1 = (Project) o;
        return id == project1.id && departmentNameId == project1.departmentNameId && departmentNameIdItCompaniesID == project1.departmentNameIdItCompaniesID && project.equals(project1.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, project, departmentNameId, departmentNameIdItCompaniesID);
    }
}
