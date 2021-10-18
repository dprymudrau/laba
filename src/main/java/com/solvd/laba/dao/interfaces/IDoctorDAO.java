package com.solvd.laba.dao.interfaces;

import com.solvd.laba.binary.Car;
import com.solvd.laba.binary.Doctor;

import java.sql.Date;
import java.util.ArrayList;

public interface IDoctorDAO extends IEntityDAO<Doctor, Integer> {
    void insertToTable(String doctorName, String doctorSurname, Date doctorDateOfBirth, int idWorkPosition, int idSpecialty, int idNumberOfContract, int idWorkExp);
    ArrayList<Doctor> getAllWithFilter(String condition);
    void deleteByFilter(String condition);
    void printByFilter(String condition);
}
