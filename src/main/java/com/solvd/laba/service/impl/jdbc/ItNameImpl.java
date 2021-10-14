package com.solvd.laba.service.impl.jdbc;

import com.solvd.laba.binary.Emploee;
import com.solvd.laba.binary.ITCompanyContact;
import com.solvd.laba.dao.interfases.EmploeeDAO;
import com.solvd.laba.service.MyService;
import com.solvd.laba.service.SetNameServise;
import com.solvd.laba.utils.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ItNameImpl implements MyService, SetNameServise {
    private static final Logger LOGGER = LogManager.getLogger(MyServiceImpl.class);
    private static MyBatis MyBatisFactory;
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    public ItNameImpl() {
    }

    public ItNameImpl(Object id) {
        ITCompanyContact contact = new ITCompanyContact();
        contact.setiTCCName((String) setCCName(id));
        contact.setiTCCSurname((String) setCCSurname(id));
        contact.setiTCCPatronymic((String) setCCPatronymic(id));
    }

    //iTCCName
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
