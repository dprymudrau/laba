package com.solvd.laba.dao.connectionPool;


import com.solvd.laba.util.ConfigUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class MyConnectionPool {
    private static final int MAX_POOL_SIZE = 5;
    private final Vector<Connection> connectionPool = new Vector<>(MAX_POOL_SIZE);

    public MyConnectionPool(String driver) {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private Connection getConnection() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(ConfigUtil.getProperty("url"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connect;
    }

    public synchronized Connection retrieve() throws SQLException {
        Connection newConnect;
        if (connectionPool.size() == 0) {
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
