package com.solvd.laba.service.implementation.jdbc;

import com.solvd.laba.binary.Street;
import com.solvd.laba.dao.jdbc.impl.StreetDaoImpl;
import com.solvd.laba.service.interfaces.StreetService;

public class StreetServiceImpl implements StreetService {

    @Override
    public Street getById(int id) {
        StreetDaoImpl streetDao = new StreetDaoImpl();
        return streetDao.getById(id);
    }
}
