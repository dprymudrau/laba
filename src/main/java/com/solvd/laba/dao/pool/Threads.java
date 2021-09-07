package com.solvd.laba.dao.pool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.SQLException;

import static com.solvd.laba.dao.pool.ConnectionPool.getInstance;

public class Threads extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(Threads.class);

    public Threads(String name){
        super(name);
    }

    public void run(){
        LOGGER.info(Thread.currentThread().getName()+"-s started... \n");
        ConnectionPool connectionPool = getInstance();
        Connection conName = null;
        try {
            conName = connectionPool.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        LOGGER.info(Thread.currentThread().getName() +"-s fiished... \n");
        connectionPool.releaseCon(conName);
    }
}