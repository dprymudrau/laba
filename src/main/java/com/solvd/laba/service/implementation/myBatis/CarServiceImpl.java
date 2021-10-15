package com.solvd.laba.service.implementation.myBatis;

import com.solvd.laba.binary.Car;
import com.solvd.laba.service.interfaces.CarService;
import com.solvd.laba.utils.myBatis.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class CarServiceImpl implements CarService {
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();


    @Override
    public Car getById(int id) {
        Car car;
        try (SqlSession session = factory.openSession()) {
            CarService carDAO = session.getMapper(CarService.class);
            car = carDAO.getById(id);
        }
        return car;
    }
    }

