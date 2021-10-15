package com.solvd.laba.service.implementation.myBatis;

import com.solvd.laba.dao.jdbc.impl.StreetsDaoImpl;
import com.solvd.laba.service.interfaces.IStreets;
import com.solvd.laba.binary.Street;
import com.solvd.laba.utils.myBatis.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class StreetsImpl implements IStreets{
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    @Override
    public Street getById(int id) {
        StreetsDaoImpl streetDao = new StreetsDaoImpl();
        return streetDao.getById(id);
    }

    public Street getStreetsDAOId (int id){
        Street street;
        try (SqlSession session = factory.openSession()) {
            IStreets streetsDAO = session.getMapper(IStreets.class);
            street = streetsDAO.getById(id);
        }
        return street;
    }
}
