package com.solvd.laba.dao.connectionPool;

import com.solvd.laba.util.ConfigUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class MyConnectionPool {
    private static volatile MyConnectionPool instance;
    private static final int MAX_POOL_SIZE = 5;
    private final Vector<Connection> connectionPool = new Vector<>(MAX_POOL_SIZE);

    private static final Logger LOGGER = LogManager.getLogger(MyConnectionPool.class);

    public MyConnectionPool() {
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

    public synchronized Connection retrieve() throws SQLException {
        Connection newConnect;
        if (connectionPool.size() < MAX_POOL_SIZE) {
            newConnect = getConnection();
            connectionPool.add(newConnect);
        } else {
            newConnect = connectionPool.lastElement();
            connectionPool.removeElement(newConnect);
        }
        return newConnect;
    }

    public synchronized void putBack(Connection connection) {
        connectionPool.add(connection);
    }
}
