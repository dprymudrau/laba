package com.solvd.laba.binary;

import java.util.Objects;

public class VisitorCategory {
    private int id;
    private String healthConditionCategory;
    private String visitCategory;

    public VisitorCategory(int id, String healthConditionCategory, String visitCategory) {
        this.id = id;
        this.healthConditionCategory = healthConditionCategory;
        this.visitCategory = visitCategory;
    }

    public VisitorCategory() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHealthConditionCategory() {
        return healthConditionCategory;
    }

    public void setHealthConditionCategory(String healthConditionCategory) {
        this.healthConditionCategory = healthConditionCategory;
    }

    public String getVisitCategory() {
        return visitCategory;
    }

    public void setVisitCategory(String visitCategory) {
        this.visitCategory = visitCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VisitorCategory)) return false;
        VisitorCategory that = (VisitorCategory) o;
        return id == that.id && healthConditionCategory.equals(that.healthConditionCategory) && visitCategory.equals(that.visitCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, healthConditionCategory, visitCategory);
    }

    @Override
    public String toString() {
        return "VisitorCategory{" +
                "id=" + id +
                ", healthConditionCategory='" + healthConditionCategory + '\'' +
                ", visitCategory='" + visitCategory + '\'' +
                '}';
    }
}
