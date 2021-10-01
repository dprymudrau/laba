package com.solvd.laba.pojo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Drivers {
    private static final Logger LOGGER = LogManager.getLogger(Drivers.class);
    private String Name;
    private int Id;
    private int Age;
    private int phoneNumber;

    public Drivers(String name, int id, int age, int phoneNumber) {
        Name = name;
        Id = id;
        Age = age;
        this.phoneNumber = phoneNumber;
    }

    public Drivers() {

    }

    public static Logger getLOGGER() {
        return LOGGER;
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

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Drivers{" +
                "Name='" + Name + '\'' +
                ", Id=" + Id +
                ", Age=" + Age +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
