package com.solvd.laba.binary;

import java.util.Objects;

public class OrderType {
    private String Name;
    private int Id;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderType orderType = (OrderType) o;
        return Id == orderType.Id && Objects.equals(Name, orderType.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Id);
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
    public String toString() {
        return "OrderType{" +
                "Name='" + Name + '\'' +
                ", Id=" + Id +
                '}';
    }
}
