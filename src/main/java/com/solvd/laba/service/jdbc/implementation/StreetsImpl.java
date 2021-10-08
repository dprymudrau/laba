package com.solvd.laba.service;

import com.solvd.laba.dao.interfaces.IStreet;
import com.solvd.laba.binary.Streets;
import com.solvd.laba.utils.myBatis.MyBatis;

public class StreetsImpl {
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    public Streets getStreetDAOId (int id){
        Streets streets;
        try (SqlSession session = factory.openSession()) {
            IStreet streetsDAO = session.getMapper(IStreet.class);
            streets = streetsDAO.getById(id);
        }
        return streets;
    }
}
