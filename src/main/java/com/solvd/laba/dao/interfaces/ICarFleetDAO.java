package com.solvd.laba.dao.interfaces;

import com.solvd.laba.binary.Car;
import com.solvd.laba.binary.CarFleet;

import java.util.ArrayList;

public interface ICarFleetDAO extends IEntityDAO<CarFleet, Integer> {
    void insertToTable(int capacityByCars);
    ArrayList<CarFleet> getAllWithFilter(String condition);
    void deleteByFilter(String condition);
    void printByFilter(String condition);
}
