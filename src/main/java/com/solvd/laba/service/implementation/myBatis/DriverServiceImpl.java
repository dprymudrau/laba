package com.solvd.laba.service.implementation.myBatis;

import com.solvd.laba.binary.Driver;
import com.solvd.laba.service.interfaces.DriverService;
import com.solvd.laba.utils.myBatis.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DriverServiceImpl implements DriverService {
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    @Override
    public Driver getById(int id) {
        Driver driver;
        try (SqlSession session = factory.openSession()) {
            DriverService driverDAO = session.getMapper(DriverService.class);
            driver = driverDAO.getById(id);
        }
        return driver;
    }
}
