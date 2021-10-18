package com.solvd.laba.dao.interfaces;

import com.solvd.laba.binary.Car;
import com.solvd.laba.binary.VisitorCategory;

import java.util.ArrayList;

public interface IVisitorCategoryDAO extends IEntityDAO<VisitorCategory, Integer> {
    void insertToTable(String healthConditionCategory, String visitCategory);
    ArrayList<VisitorCategory> getAllWithFilter(String condition);
    void deleteByFilter(String condition);
    void printByFilter(String condition);
}
