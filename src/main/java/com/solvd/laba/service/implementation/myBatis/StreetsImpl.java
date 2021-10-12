package com.solvd.laba.service.implementation.myBatis;

import com.solvd.laba.dao.jdbc.impl.StreetsDaoImpl;
import com.solvd.laba.service.interfaces.IStreets;
import com.solvd.laba.binary.Streets;
import com.solvd.laba.utils.myBatis.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class StreetsImpl implements IStreets{
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    @Override
    public Streets getById(int id) {
        StreetsDaoImpl streetDao = new StreetsDaoImpl();
        return streetDao.getById(id);
    }

    public Streets getStreetsDAOId (int id){
        Streets streets;
        try (SqlSession session = factory.openSession()) {
            IStreets streetsDAO = session.getMapper(IStreets.class);
            streets = streetsDAO.getById(id);
        }
        return streets;
    }
}
