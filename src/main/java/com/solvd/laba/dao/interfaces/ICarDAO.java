package com.solvd.laba.dao.interfaces;

import com.solvd.laba.binary.Car;

import java.util.ArrayList;

public interface ICarDAO extends IEntityDAO<Car, Integer> {
    void insertToTable(String carBrandName, String carModel, String carRegNumber, int idCarFleet);
    ArrayList<Car> getAllByCarFleetId(Integer condition);
    void deleteByFilter(String condition);
    void printByFilter(String condition);
}
