package com.solvd.laba.utils.pool;

import com.solvd.laba.utils.ConfigUtils;
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
            Class.forName(ConfigUtils.getProperty("driver")).getDeclaredConstructor().newInstance();
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
                sleep(3000);
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

    private Connection connectionCreate(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(ConfigUtils.getProperty("url"), ConfigUtils.getProperty("username"), ConfigUtils.getProperty("password"));
            LOGGER.info("Connection to Store DB succesfull!");
        } catch(SQLException ex){
            LOGGER.info("Connection failed...");
            LOGGER.info(ex);
        }
        return conn;
    }

    private void sleep(int timeout) {
        try {
            LOGGER.info("TimeOut");
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
