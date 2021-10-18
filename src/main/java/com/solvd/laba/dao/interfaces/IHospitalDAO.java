package com.solvd.laba.dao.interfaces;

import com.solvd.laba.binary.Car;
import com.solvd.laba.binary.Hospital;

import java.util.ArrayList;

public interface IHospitalDAO extends IEntityDAO<Hospital, Integer> {
    void insertToTable(String hospitalName, String hospitalAddress, int idCarFleet);
    ArrayList<Hospital> getAllWithFilter(String condition);
    void deleteByFilter(String condition);
    void printByFilter(String condition);
}
