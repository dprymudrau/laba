package com.solvd.laba.dao.interfaces;

import com.solvd.laba.binary.Car;
import com.solvd.laba.binary.Visitor;

import java.sql.Date;
import java.util.ArrayList;

public interface IVisitorDAO extends IEntityDAO<Visitor, Integer> {
    void insertToTable(String name, String surname, Date birthday, String address, String diagnosis, Date visitDate, Date dischargeDate);
    ArrayList<Visitor> getAllWithFilter(String condition);
    void deleteByFilter(String condition);
    void printByFilter(String condition);
}
