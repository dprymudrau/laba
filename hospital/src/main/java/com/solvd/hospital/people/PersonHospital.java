package com.solvd.hospital.people;

public abstract class PersonHospital {
    private String Fio;
    private int age;
    private String sex;

    public PersonHospital(String Fio, int age, String sex) {
        this.Fio = Fio;
        this.age = age;
        this.sex = sex;
    }

    public String getFio() {
        return Fio;
    }

    public void setFio(String Fio) {
        this.Fio = Fio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setNumber(String sex) {
        this.sex = sex;
    }
}