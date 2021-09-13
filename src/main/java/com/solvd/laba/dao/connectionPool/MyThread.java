package com.solvd.laba.dao.connectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class MyThread implements Runnable {
    Thread thread;
    private MyConnectionPool pool;

    public MyThread(String threadName, MyConnectionPool connectionPool) {
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
