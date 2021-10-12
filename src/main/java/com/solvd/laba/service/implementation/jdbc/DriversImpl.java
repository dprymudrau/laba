package com.solvd.laba.service.implementation.jdbc;

import com.solvd.laba.binary.Drivers;
import com.solvd.laba.dao.jdbc.impl.DriversDaoImpl;
import com.solvd.laba.service.interfaces.IDrivers;

public class DriversImpl implements IDrivers {
    @Override
    public Drivers getById(int id) {
        DriversDaoImpl driversDao = new DriversDaoImpl();
        return driversDao.getById(id);
    }

    @Override
    public Drivers getDriversDAOId(int id) {
        return null;
    }
}
