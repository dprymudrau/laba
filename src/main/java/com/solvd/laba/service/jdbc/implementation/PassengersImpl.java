package com.solvd.laba.service.jdbc.implementation;

import com.solvd.laba.dao.interfaces.IPassenger;
import com.solvd.laba.service.interfaces.IPassengers;
import com.solvd.laba.binary.Passenger;
import com.solvd.laba.utils.myBatis.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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
