package com.solvd.laba.service.impl.myBatis;

import com.solvd.laba.binary.СustomerСontact;
import com.solvd.laba.service.MyService;
import com.solvd.laba.service.SetNameServise;
import com.solvd.laba.service.impl.jdbc.MyServiceImpl;
import com.solvd.laba.utils.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustNameImpl implements MyService, SetNameServise {
    private static final Logger LOGGER = LogManager.getLogger(MyServiceImpl.class);
    private static MyBatis MyBatisFactory;
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    public CustNameImpl(SetNameServise sCName) {
    }

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
    public Object setById(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public Object checkDb(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public Object getCCName(Object id) {
        СustomerСontact custumerC = null;
        try {
            SqlSession sqlSession = factory.openSession();
            CustContactImpl cCName = sqlSession.getMapper(CustContactImpl.class);
            custumerC = (СustomerСontact) cCName.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return custumerC;
    }

    @Override
    public Object setCCName(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public Object getCCSurname(Object id) {
        СustomerСontact custumerC = null;
        try {
            SqlSession sqlSession = factory.openSession();
            CustContactImpl cCSurname = sqlSession.getMapper(CustContactImpl.class);
            custumerC = (СustomerСontact) cCSurname.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return custumerC;
    }

    @Override
    public Object setCCSurname(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public Object getCCPatronymic(Object id) {
        СustomerСontact custumerC = null;
        try {
            SqlSession sqlSession = factory.openSession();
            CustContactImpl cCPatronymic = sqlSession.getMapper(CustContactImpl.class);
            custumerC = (СustomerСontact) cCPatronymic.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return custumerC;
    }

    @Override
    public Object setCCPatronymic(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public void doSmth() {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }
}
