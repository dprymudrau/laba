package com.solvd.laba.service.impl.myBatis;

import com.solvd.laba.binary.*;
import com.solvd.laba.service.MyService;
import com.solvd.laba.service.SetContactData;
import com.solvd.laba.utils.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustContactImpl implements MyService, SetContactData {
    private static final Logger LOGGER = LogManager.getLogger(com.solvd.laba.service.impl.jdbc.MyServiceImpl.class);
    private static MyBatis MyBatisFactory;
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();


    @Override
    public Object getById(Object id) {
        СustomerСontact custumerC = null;
        try {
            SqlSession sqlSession = factory.openSession();
            CustContactImpl custC = sqlSession.getMapper(CustContactImpl.class);
            custumerC = (СustomerСontact) custC.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return custumerC;
    }

    @Override
    public Object emailsID(Object id) {
        СustomerСontact custumerC = null;
        try {
            SqlSession sqlSession = factory.openSession();
            CustContactImpl custC = sqlSession.getMapper(CustContactImpl.class);
            custumerC = (СustomerСontact) custC.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return custumerC;
    }

    @Override
    public Object phoneNumbersID(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public void doSmth() {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public Object setById(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public Object checkDb(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }
}
