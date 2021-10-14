package com.solvd.laba.service.impl.jdbc;

import com.solvd.laba.binary.Emploee;
import com.solvd.laba.binary.СustomerСontact;
import com.solvd.laba.dao.interfases.EmploeeDAO;
import com.solvd.laba.service.MyService;
import com.solvd.laba.service.SetNameServise;
import com.solvd.laba.utils.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SetCustNameImpl implements MyService, SetNameServise {
    private static final Logger LOGGER = LogManager.getLogger(MyServiceImpl.class);
    private static MyBatis MyBatisFactory;
    private final static SqlSessionFactory factory= MyBatis.getSessionFactory();

    private SetCustNameImpl(Object id){
        СustomerСontact contact = new СustomerСontact();
        contact.setcCName((String) setCCName(id));
        contact.setcCSurname((String) setCCSurname(id));
        contact.setcCPatronymic((String) setCCPatronymic(id));

    }

    @Override
    public Object getCCName(Object id) {
        return null;
    }

    @Override
    public Object setCCName(Object id) {
        return null;
    }

    @Override
    public Object getCCSurname(Object id) {
        return null;
    }

    @Override
    public Object setCCSurname(Object id) {
        return null;
    }

    @Override
    public Object getCCPatronymic(Object id) {
        return null;
    }

    @Override
    public Object setCCPatronymic(Object id) {
        return null;
    }

    @Override
    public void doSmth() {

    }

    @Override
    public Object getById(Object id) {
        Emploee emploee = null;
        try{
            SqlSession sqlSession = factory.openSession();
            EmploeeDAO emploeeDAO = sqlSession.getMapper(EmploeeDAO.class);
            emploee = EmploeeDAO.getById();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emploee;
    }

    @Override
    public Object setById(Object id) {
        return null;
    }

    @Override
    public Object checkDb(Object id) {
        return null;
    }
}
