package com.solvd.laba.threads;

import com.solvd.laba.dao.connectionPool.MyConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class MyThread implements Runnable {
    Thread thread;
    private MyConnectionPool pool;

    private static final Logger LOGGER = LogManager.getLogger();

    public MyThread(String threadName, MyConnectionPool connectionPool) throws SQLException {
        thread = new Thread(this, threadName);
        pool = connectionPool;
        thread.start();
    }

    @Override
    public void run() {
        try {
            Connection connection = pool.retrieve();
            //To DO сделать запрос к базе данных
            pool.putBack(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
