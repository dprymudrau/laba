package com.solvd.laba.utils.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;

import static com.solvd.laba.utils.pool.ConnectionPool.getInstance;

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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info(Thread.currentThread().getName() +"-s fiished... \n");
    }
}
