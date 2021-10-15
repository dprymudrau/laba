package com.solvd.laba.service.implementation.jdbc;

import com.solvd.laba.binary.Car;
import com.solvd.laba.dao.jdbc.impl.CarDaoImpl;
import com.solvd.laba.service.interfaces.CarService;

public class CarServiceImpl implements CarService {
    @Override
    public Car getById(int id) {
        CarDaoImpl carDao = new CarDaoImpl();
        return carDao.getById(id);
    }
}
