package com.solvd.laba.service.implementation.jdbc;

import com.solvd.laba.binary.Street;
import com.solvd.laba.dao.jdbc.impl.StreetsDaoImpl;
import com.solvd.laba.service.interfaces.IStreets;

public class StreetsImpl implements IStreets {

    @Override
    public Street getById(int id) {
        StreetsDaoImpl streetDao = new StreetsDaoImpl();
        return streetDao.getById(id);
    }

    @Override
    public Street getStreetsDAOId(int id) {
        return null;
    }
}
