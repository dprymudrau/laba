package com.solvd.hospital.people;


public class Doctor extends Worker {

    private String specialization;
    private int numberPatient;
    private String category;

    public Doctor(String Fio, int age, String sex, int numberWorker,
                  int salary, int workExperience, String specialization, int numberPatient, String category) {
        super(Fio, age, sex, numberWorker, salary, workExperience);
        this.specialization = specialization;
        this.numberPatient = numberPatient;
        this.category = category;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getNumberPatient() {
        return numberPatient;
    }

    public void setNumberPatient(int numberPatient) {
        this.numberPatient = numberPatient;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}