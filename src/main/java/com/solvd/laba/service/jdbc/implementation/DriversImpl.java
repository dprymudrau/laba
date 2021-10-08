package com.solvd.laba.service.jdbc.implementation;

import com.solvd.laba.dao.interfaces.IDriver;
import com.solvd.laba.service.interfaces.IDrivers;
import com.solvd.laba.binary.Drivers;
import com.solvd.laba.utils.myBatis.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DriversImpl {
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    public Drivers getDriversDAOId (int id){
        Drivers driver;
        try (SqlSession session = factory.openSession()) {
            IDrivers driverDAO = session.getMapper(IDrivers.class);
            driver = driverDAO.getById(id);
        }
        return driver;
    }
}
