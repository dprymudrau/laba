package com.solvd.laba.util.connectionPool;

import com.solvd.laba.util.ConfigUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class MyConnectionPool {
    private static volatile MyConnectionPool instance;
    private static final int MAX_POOL_SIZE = 5;
    private static volatile int connectionsCounter = 0;
    private final List<Connection> connectionPool = new ArrayList<>();

    private static final Logger LOGGER = LogManager.getLogger(MyConnectionPool.class);

    private MyConnectionPool() {
        try {
            Class.forName(ConfigUtil.getProperty("driver"));
            LOGGER.info("Create successfully connection to MySQL!");
        } catch (Exception e) {
            LOGGER.error("Connection to MySQL is failed!" + e);
        }
    }

    public static MyConnectionPool getInstance() {
        if (instance == null) {
            synchronized (MyConnectionPool.class) {
                if (instance == null) {
                    instance = new MyConnectionPool();
                }
            }
        }
        return instance;
    }

    private Connection getConnection() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(ConfigUtil.getProperty("url"),
                    ConfigUtil.getProperty("username"), ConfigUtil.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connect;
    }

    public synchronized Connection retrieve() throws SQLException, InterruptedException, TimeoutException {

            if (connectionsCounter < MAX_POOL_SIZE) {
                ++connectionsCounter;
                return getConnection();
            } else {
                for (int i = 0; i < 5; i++){
                    if (!connectionPool.isEmpty()) {
                        return connectionPool.remove(0);
                    }
                    Thread.sleep(2000);
                }
                throw new TimeoutException();
            }
    }

    public synchronized void putBack(Connection connection) {
        connectionPool.add(connection);
        LOGGER.debug("Thread_№" + Thread.currentThread().getName() + " finished to use connection");
    }
}
