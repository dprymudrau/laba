package com.solvd.laba.utils;

import com.solvd.laba.Main;
import com.solvd.laba.binary.Emploee;
import com.solvd.laba.dao.jdbc.impl.MyDAOImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BusinessLogic {
    private static final Logger LOGGER = LogManager.getLogger(BusinessLogic.class);

    public static void businessLogic(){
        Emploee emploee = new Emploee();
        emploee.getcCName();
    }

}
