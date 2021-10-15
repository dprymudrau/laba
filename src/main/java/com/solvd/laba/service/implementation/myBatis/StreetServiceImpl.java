package com.solvd.laba.service.implementation.myBatis;

import com.solvd.laba.service.interfaces.StreetService;
import com.solvd.laba.binary.Street;
import com.solvd.laba.utils.myBatis.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class StreetServiceImpl implements StreetService {
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    @Override
    public Street getById(int id) {
        Street street;
        try (SqlSession session = factory.openSession()) {
            StreetService streetsDAO = session.getMapper(StreetService.class);
            street = streetsDAO.getById(id);
        }
        return street;
    }
}
