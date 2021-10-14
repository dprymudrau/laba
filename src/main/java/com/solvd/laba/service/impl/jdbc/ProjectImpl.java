package com.solvd.laba.service.impl.jdbc;

import com.solvd.laba.service.MyService;
import com.solvd.laba.service.ProjectServise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProjectImpl implements MyService, ProjectServise {
    private static final Logger LOGGER = LogManager.getLogger(MyServiceImpl.class);

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
        throw new UnsupportedOperationException("This method isn't implemented for Jdbc Service");
    }

    @Override
    public Object getProject(Object id) {
        return null;
    }

    @Override
    public Object setProject(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for Jdbc Service");
    }
}
