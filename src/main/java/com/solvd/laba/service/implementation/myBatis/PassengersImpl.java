package com.solvd.laba.service.implementation.myBatis;

import com.solvd.laba.binary.Passenger;
import com.solvd.laba.dao.jdbc.impl.PassengerDaoImpl;
import com.solvd.laba.service.interfaces.IPassengers;
import com.solvd.laba.utils.myBatis.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PassengersImpl implements IPassengers {
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    @Override
    public Passenger getById(int id) {
        PassengerDaoImpl passengerDao = new PassengerDaoImpl();
        return passengerDao.getById(id);
    }

    public Passenger getPassengerDAOId (int id){
        Passenger passenger;
        try (SqlSession session = factory.openSession()) {
            IPassengers passengerDAO = session.getMapper(IPassengers.class);
            passenger = passengerDAO.getById(id);
        }
        return passenger;
    }
}
