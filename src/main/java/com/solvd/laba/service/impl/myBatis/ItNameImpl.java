package com.solvd.laba.service.impl.myBatis;

import com.solvd.laba.binary.Emploee;
import com.solvd.laba.binary.ITCompanyContact;
import com.solvd.laba.binary.СustomerСontact;
import com.solvd.laba.dao.interfases.EmploeeDAO;
import com.solvd.laba.service.MyService;
import com.solvd.laba.service.SetNameServise;
import com.solvd.laba.service.impl.jdbc.MyServiceImpl;
import com.solvd.laba.utils.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ItNameImpl implements MyService, SetNameServise {
    private static final Logger LOGGER = LogManager.getLogger(MyServiceImpl.class);
    private static MyBatis MyBatisFactory;
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    public ItNameImpl(Object sItName) {
    }

    @Override
    public Object getById(Object id) {
        ITCompanyContact contact = null;
        try {
            SqlSession sqlSession = factory.openSession();
            ItContactImpl emploeeDAO = sqlSession.getMapper(ItContactImpl.class);
            contact = (ITCompanyContact) emploeeDAO.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contact;
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
        ITCompanyContact contact = null;
        try {
            SqlSession sqlSession = factory.openSession();
            CustContactImpl iTCCName = sqlSession.getMapper(CustContactImpl.class);
            contact = (ITCompanyContact) iTCCName.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contact;
    }

    @Override
    public Object setCCName(Object id) {
        return null;
    }

    @Override
    public Object getCCSurname(Object id) {
        ITCompanyContact contact = null;
        try {
            SqlSession sqlSession = factory.openSession();
            CustContactImpl iTCCSurname = sqlSession.getMapper(CustContactImpl.class);
            contact = (ITCompanyContact) iTCCSurname.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contact;
    }

    @Override
    public Object setCCSurname(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public Object getCCPatronymic(Object id) {
        ITCompanyContact contact = null;
        try {
            SqlSession sqlSession = factory.openSession();
            CustContactImpl iTCCPatronymic = sqlSession.getMapper(CustContactImpl.class);
            contact = (ITCompanyContact) iTCCPatronymic.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contact;
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
