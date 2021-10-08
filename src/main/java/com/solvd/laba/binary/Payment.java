package com.solvd.laba.pojo;

import java.util.Objects;

public class Payment {
    private String Name;
    private int Id;

    public Payment(String name, int id) {
        Name = name;
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Id == payment.Id && Objects.equals(Name, payment.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Id);
    }
}
