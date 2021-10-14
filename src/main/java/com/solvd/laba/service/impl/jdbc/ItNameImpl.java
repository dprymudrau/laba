package com.solvd.laba.service.impl.jdbc;

import com.solvd.laba.binary.ITCompanyContact;
import com.solvd.laba.service.MyService;
import com.solvd.laba.service.SetNameServise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ItNameImpl implements MyService, SetNameServise {
    private static final Logger LOGGER = LogManager.getLogger(MyServiceImpl.class);

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
        throw new UnsupportedOperationException("This method isn't implemented for Jdbc Service");
    }

    @Override
    public Object getCCSurname(Object id) {
        return null;
    }

    @Override
    public Object setCCSurname(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for Jdbc Service");
    }

    @Override
    public Object getCCPatronymic(Object id) {
        return null;
    }

    @Override
    public Object setCCPatronymic(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for Jdbc Service");
    }

    @Override
    public void doSmth() {
        throw new UnsupportedOperationException("This method isn't implemented for Jdbc Service");

    }

    @Override
    public Object getById(Object id) {
        return null;
    }

    @Override
    public Object setById(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for Jdbc Service");
    }

    @Override
    public Object checkDb(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for Jdbc Service");
    }
}
