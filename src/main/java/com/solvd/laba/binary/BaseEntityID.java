package com.solvd.laba.binary;

public class BaseEntityID {
    private int id;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id=" + id;
    }
}
