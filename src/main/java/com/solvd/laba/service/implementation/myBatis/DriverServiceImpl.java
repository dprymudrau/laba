package com.solvd.laba.service.implementation.myBatis;

import com.solvd.laba.binary.Driver;
import com.solvd.laba.dao.jdbc.impl.DriversDaoImpl;
import com.solvd.laba.service.interfaces.IDrivers;
import com.solvd.laba.utils.myBatis.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DriversImpl implements IDrivers {
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    @Override
    public Driver getById(int id) {
            DriversDaoImpl driversDao = new DriversDaoImpl();
            return driversDao.getById(id);
    }

    public Driver getDriversDAOId (int id){
        Driver driver;
        try (SqlSession session = factory.openSession()) {
            IDrivers driverDAO = session.getMapper(IDrivers.class);
            driver = driverDAO.getById(id);
        }
        return driver;
    }
}
