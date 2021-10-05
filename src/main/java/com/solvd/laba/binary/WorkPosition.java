package com.solvd.laba.binary;

import java.util.Objects;

public class WorkPosition {
    private int id;
    private String nameOfPosition;
    private String nameOfCategory;

    public WorkPosition(int id, String nameOfPosition, String nameOfCategory) {
        this.id = id;
        this.nameOfPosition = nameOfPosition;
        this.nameOfCategory = nameOfCategory;
    }

    public WorkPosition() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfPosition() {
        return nameOfPosition;
    }

    public void setNameOfPosition(String nameOfPosition) {
        this.nameOfPosition = nameOfPosition;
    }

    public String getNameOfCategory() {
        return nameOfCategory;
    }

    public void setNameOfCategory(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkPosition)) return false;
        WorkPosition that = (WorkPosition) o;
        return id == that.id && nameOfPosition.equals(that.nameOfPosition) && nameOfCategory.equals(that.nameOfCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfPosition, nameOfCategory);
    }

    @Override
    public String toString() {
        return "WorkPosition{" +
                "id=" + id +
                ", nameOfPosition='" + nameOfPosition + '\'' +
                ", nameOfCategory='" + nameOfCategory + '\'' +
                '}';
    }
}
