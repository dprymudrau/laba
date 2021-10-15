package com.solvd.laba.service.implementation.myBatis;

import com.solvd.laba.binary.Passenger;
import com.solvd.laba.dao.jdbc.impl.PassengerDaoImpl;
import com.solvd.laba.service.interfaces.PassengerService;
import com.solvd.laba.utils.myBatis.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PassengerServiceImpl implements PassengerService {
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    @Override
    public Passenger getById(int id) {
        Passenger passenger;
        try (SqlSession session = factory.openSession()) {
            PassengerService passengerDAO = session.getMapper(PassengerService.class);
            passenger = passengerDAO.getById(id);
        }
        return passenger;
    }
}
