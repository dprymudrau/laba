package com.solvd.laba.poJo;

import java.util.Objects;

public class DepartmentName extends BaseEntityID{

    private String departmentName;
    private int itCompaniesId;

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
        String id = super.toString();
        return "DepartmentName{" + id +
                ", departmentName='" + departmentName + '\'' +
                ", itCompaniesId=" + itCompaniesId +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        DepartmentName guest = (DepartmentName) obj;
        boolean b = super.equals(obj)&& (guest.departmentName == this.departmentName) && (guest.itCompaniesId == this.itCompaniesId);
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), departmentName, itCompaniesId);
    }





}
