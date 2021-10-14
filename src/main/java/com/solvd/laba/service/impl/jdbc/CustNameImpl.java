package com.solvd.laba.service.impl.jdbc;

import com.solvd.laba.binary.СustomerСontact;
import com.solvd.laba.service.MyService;
import com.solvd.laba.service.SetNameServise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustNameImpl implements MyService, SetNameServise {
    private static final Logger LOGGER = LogManager.getLogger(MyServiceImpl.class);


    public CustNameImpl(Object id) {
        СustomerСontact contact = new СustomerСontact();
        contact.setcCName((String) setCCName(id));
        contact.setcCSurname((String) setCCSurname(id));
        contact.setcCPatronymic((String) setCCPatronymic(id));
    }

    public CustNameImpl() {
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
        return null;
    }

    @Override
    public Object setById(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for Jdbc Service");
    }

    @Override
    public Object checkDb(Object id) {
        return null;
    }
}
