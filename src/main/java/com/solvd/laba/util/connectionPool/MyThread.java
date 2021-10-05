package com.solvd.laba.util.connectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

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
            pool.putBack(connection);
        } catch (SQLException | InterruptedException | TimeoutException throwables) {
            throwables.printStackTrace();
        }
    }

}
