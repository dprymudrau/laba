package com.solvd.hospital.people;

public class MedicalStaff extends Worker{
    private String education;
    private boolean student; // is the worker student?

    public MedicalStaff(String Fio, int age, String sex, int numberWorker,
                        int salary, int workExperience, String education, boolean student) {
        super(Fio, age, sex, numberWorker, salary, workExperience);
        this.education = education;
        this.student = student;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public boolean getStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }
}