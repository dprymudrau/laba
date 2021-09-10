package com.solvd.laba.poJo;

import java.util.Objects;

public class DepartmentName {

    private int id;
    private String departmentName;
    private int itCompaniesId;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getItCompaniesId() {
        return itCompaniesId;
    }
    public void setItCompaniesId(int itCompaniesId) {
        this.itCompaniesId = itCompaniesId;
    }


    @Override
    public String toString() {
        return "DepartmentName{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", itCompaniesId=" + itCompaniesId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentName that = (DepartmentName) o;
        return id == that.id && itCompaniesId == that.itCompaniesId && departmentName.equals(that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentName, itCompaniesId);
    }





}
