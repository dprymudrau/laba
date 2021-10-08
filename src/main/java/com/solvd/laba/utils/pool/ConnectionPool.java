package com.solvd.laba.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool instance;
    private static final int MAX_AMOUNT_OF_CON = 5;
    private int createdConAmount = 0;
    private List<Connection> connectionPool = new ArrayList<>(MAX_AMOUNT_OF_CON);


    private ConnectionPool() {
        try {// The newInstance() call is a work around for some broken Java implementations
            Class.forName(Config.getProperty("driver")).getDeclaredConstructor().newInstance();
            LOGGER.info("Driver add successfully");
        } catch (Exception ex) {
            LOGGER.error("Driver connection error");
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        if (createdConAmount < MAX_AMOUNT_OF_CON) {
            Connection conn = connectionCreate();
            createdConAmount++;
            return conn;
        } else {
            if (!connectionPool.isEmpty()) {
                return connectionPool.remove(0);
            } else {
                return null;
            }
        }
    }

    public synchronized void releaseCon(Connection connection) throws NullPointerException {
        if (connection != null) {
            connectionPool.add(connection);
        } else {
            throw new NullPointerException("Connection not in the usedCon array");
        }
    }

    private Connection connectionCreate() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Config.getProperty("url"),
                    Config.getProperty("username"), Config.getProperty("password"));
            LOGGER.info("Connection is succesfull");
        } catch (SQLException ex) {
            LOGGER.info("Connection failed");
            LOGGER.info(ex);
        }
        return connection;
    }
}