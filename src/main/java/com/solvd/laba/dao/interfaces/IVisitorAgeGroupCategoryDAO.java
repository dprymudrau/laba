package com.solvd.laba.dao.interfaces;

import com.solvd.laba.binary.Car;
import com.solvd.laba.binary.VisitorAgeGroupCategory;

import java.util.ArrayList;

public interface IVisitorAgeGroupCategoryDAO extends IEntityDAO<VisitorAgeGroupCategory, Integer> {
    void insertToTable(String ageGroupCategory);
    ArrayList<VisitorAgeGroupCategory> getAllWithFilter(String condition);
    void deleteByFilter(String condition);
    void printByFilter(String condition);
}
