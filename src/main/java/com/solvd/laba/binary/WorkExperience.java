package com.solvd.laba.binary;

import java.util.Objects;

public class WorkExperience {
    private int id;
    private String totalWorkExp;
    private double salaryIndex;

    public WorkExperience(int id, String totalWorkExp, double salaryIndex) {
        this.id = id;
        this.totalWorkExp = totalWorkExp;
        this.salaryIndex = salaryIndex;
    }

    public WorkExperience() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTotalWorkExp() {
        return totalWorkExp;
    }

    public void setTotalWorkExp(String totalWorkExp) {
        this.totalWorkExp = totalWorkExp;
    }

    public double getSalaryIndex() {
        return salaryIndex;
    }

    public void setSalaryIndex(double salaryIndex) {
        this.salaryIndex = salaryIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkExperience)) return false;
        WorkExperience that = (WorkExperience) o;
        return id == that.id && Double.compare(that.salaryIndex, salaryIndex) == 0 && totalWorkExp.equals(that.totalWorkExp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalWorkExp, salaryIndex);
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "id=" + id +
                ", totalWorkExp='" + totalWorkExp + '\'' +
                ", salaryIndex=" + salaryIndex +
                '}';
    }
}
