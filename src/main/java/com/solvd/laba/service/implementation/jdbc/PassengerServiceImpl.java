package com.solvd.laba.service.implementation.jdbc;

import com.solvd.laba.binary.Passenger;
import com.solvd.laba.dao.jdbc.impl.PassengerDaoImpl;
import com.solvd.laba.dao.jdbc.impl.StreetsDaoImpl;
import com.solvd.laba.service.interfaces.IPassengers;

public class PassengerImpl implements IPassengers {
    @Override
    public Passenger getById(int id) {
        PassengerDaoImpl passengerDao = new PassengerDaoImpl();
        return passengerDao.getById(id);
    }

    @Override
    public Passenger getPassengerDAOId(int id) {
        return null;
    }
}
