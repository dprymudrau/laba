package com.solvd.laba.service.implementation.jdbc;

import com.solvd.laba.binary.Passenger;
import com.solvd.laba.dao.jdbc.impl.PassengerDaoImpl;
import com.solvd.laba.service.interfaces.PassengerService;

public class PassengerServiceImpl implements PassengerService {
    @Override
    public Passenger getById(int id) {
        PassengerDaoImpl passengerDao = new PassengerDaoImpl();
        return passengerDao.getById(id);
    }
}
