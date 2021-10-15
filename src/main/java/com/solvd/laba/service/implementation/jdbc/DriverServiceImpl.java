package com.solvd.laba.service.implementation.jdbc;

import com.solvd.laba.binary.Driver;
import com.solvd.laba.dao.jdbc.impl.DriverDaoImpl;
import com.solvd.laba.service.interfaces.DriverService;

public class DriverServiceImpl implements DriverService {
    @Override
    public Driver getById(int id) {
        DriverDaoImpl driverDao = new DriverDaoImpl();
        return driverDao.getById(id);
    }
}
