package com.solvd.laba.utils.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import static com.solvd.laba.utils.pool.ConnectionPool.getInstance;

public class ConnectionThreads extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionThreads.class);

    public ConnectionThreads(String name){
        super(name);
    }

    public void run(){
        LOGGER.info(Thread.currentThread().getName()+"start... \n");
        ConnectionPool connectionPool = getInstance();
        Connection myconnection = null;
        myconnection = connectionPool.getConnection();
        LOGGER.info(Thread.currentThread().getName() +"fiished... \n");
        connectionPool.releaseCon(myconnection);
    }
}