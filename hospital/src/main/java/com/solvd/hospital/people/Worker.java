package com.solvd.hospital.people;

public abstract class Worker extends PersonHospital {
    private int numberWorker;
    private int salary;
    private int workExperience;

    public Worker(String Fio, int age, String sex, int numberWorker, int salary, int workExperience) {
        super(Fio, age, sex);
        this.numberWorker = numberWorker;
        this.salary = salary;
        this.workExperience = workExperience;
    }

    public int getNumberWorker() {
        return numberWorker;
    }

    public void setNumberWorker(int numberWorker) {
        this.numberWorker = numberWorker;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }
}