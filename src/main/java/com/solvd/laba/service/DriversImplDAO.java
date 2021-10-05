package com.solvd.laba.service;

import com.solvd.laba.dao.interfaces.IDriver;
import com.solvd.laba.pojo.Drivers;
import com.solvd.laba.utils.myBatis.MyBatis;

public class DriversImplDAO {
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    public Drivers getDriversDAOId (int id){
        Drivers driver;
        try (SqlSession session = factory.openSession()) {
            IDriver driverDAO = session.getMapper(IDriver.class);
            driver = driverDAO.getById(id);
        }
        return driver;
    }
}
