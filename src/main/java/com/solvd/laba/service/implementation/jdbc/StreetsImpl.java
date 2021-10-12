package com.solvd.laba.service.implementation.jdbc;

import com.solvd.laba.binary.Streets;
import com.solvd.laba.dao.jdbc.impl.DriversDaoImpl;
import com.solvd.laba.dao.jdbc.impl.StreetsDaoImpl;
import com.solvd.laba.service.interfaces.IStreets;

public class StreetsImpl implements IStreets {

    @Override
    public Streets getById(int id) {
        StreetsDaoImpl streetDao = new StreetsDaoImpl();
        return streetDao.getById(id);
    }

    @Override
    public Streets getStreetsDAOId(int id) {
        return null;
    }
}
