package com.solvd.laba.pojo;

public class City {
    private String Name;
    private int Id;

    public City(String name, int id) {
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

}
