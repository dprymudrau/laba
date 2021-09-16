package com.solvd.laba.utils;

import com.solvd.laba.binary.Emploee;
import com.solvd.laba.dao.jdbc.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BusinessLogic {
    private static final Logger LOGGER = LogManager.getLogger(BusinessLogic.class);

    public static void businessLogic(){
        EmploeeDAOImpl employee = new EmploeeDAOImpl();
        Emploee employee1 = employee.getById(1L);
        ITCompanyContactDAOImpl itContact = new ITCompanyContactDAOImpl();
        ProjectDAOImpl project = new ProjectDAOImpl();
        TasksDAOImpl task = new TasksDAOImpl();
        СustomerСontactDAOImpl custСontact = new СustomerСontactDAOImpl();

    }

}
