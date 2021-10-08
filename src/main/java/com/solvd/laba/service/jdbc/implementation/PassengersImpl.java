package com.solvd.laba.service;

import com.solvd.laba.dao.interfaces.IPassenger;
import com.solvd.laba.binary.Passenger;
import com.solvd.laba.utils.myBatis.MyBatis;

public class PassengersImpl {
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    public Passenger getPassengerDAOId (int id){
        Passenger passenger;
        try (SqlSession session = factory.openSession()) {
            IPassenger passengerDAO = session.getMapper(IPassenger.class);
            passenger = passengerDAO.getById(id);
        }
        return passenger;
    }
}
