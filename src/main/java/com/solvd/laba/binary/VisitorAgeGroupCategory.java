package com.solvd.laba.binary;

import java.util.Objects;

public class VisitorAgeGroupCategory {
    private int id;
    private String ageGroupCategory;

    public VisitorAgeGroupCategory(int id, String ageGroupCategory) {
        this.id = id;
        this.ageGroupCategory = ageGroupCategory;
    }

    public VisitorAgeGroupCategory() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAgeGroupCategory() {
        return ageGroupCategory;
    }

    public void setAgeGroupCategory(String ageGroupCategory) {
        this.ageGroupCategory = ageGroupCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VisitorAgeGroupCategory)) return false;
        VisitorAgeGroupCategory that = (VisitorAgeGroupCategory) o;
        return id == that.id && ageGroupCategory.equals(that.ageGroupCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ageGroupCategory);
    }

    @Override
    public String toString() {
        return "VisitorAgeGroupCategory{" +
                "id=" + id +
                ", ageGroupCategory='" + ageGroupCategory + '\'' +
                '}';
    }
}
