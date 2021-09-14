package com.solvd.laba.pojo;

import java.util.Objects;

public class Operator {
    private String name;
    private int age;
    private String position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return age == operator.age && Objects.equals(name, operator.name) && Objects.equals(position, operator.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, position);
    }
}
