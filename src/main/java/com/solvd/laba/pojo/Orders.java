package com.solvd.laba.pojo;

import java.util.Objects;

public class Orders {
    private int number;
    private Streets name;
    private String status;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Streets getName() {
        return name;
    }

    public void setName(Streets name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return number == orders.number && Objects.equals(name, orders.name) && Objects.equals(status, orders.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, status);
    }
}
