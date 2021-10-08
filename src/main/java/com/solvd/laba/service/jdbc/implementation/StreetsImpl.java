package com.solvd.laba.service.jdbc.implementation;

import com.solvd.laba.service.interfaces.IStreets;
import com.solvd.laba.binary.Streets;
import com.solvd.laba.utils.myBatis.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class StreetsImpl {
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    public Streets getStreetDAOId (int id){
        Streets streets;
        try (SqlSession session = factory.openSession()) {
            IStreets streetsDAO = session.getMapper(IStreets.class);
            streets = streetsDAO.getById(id);
        }
        return streets;
    }
}
