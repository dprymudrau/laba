package com.solvd.laba.service.impl.jdbc;

import com.solvd.laba.binary.Emploee;
import com.solvd.laba.dao.interfases.EmploeeDAO;
import com.solvd.laba.service.MyService;
import com.solvd.laba.service.SetContactData;
import com.solvd.laba.utils.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustContactImpl implements MyService, SetContactData {
    private static final Logger LOGGER = LogManager.getLogger(MyServiceImpl.class);
    private static MyBatis MyBatisFactory;
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    @Override
    public Object emailsID(Object id) {
        return null;
    }

    @Override
    public Object phoneNumbersID(Object id) {
        return null;
    }

    @Override
    public void doSmth() {
    }

    @Override
    public Object getById(Object id) {
        return null;
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
