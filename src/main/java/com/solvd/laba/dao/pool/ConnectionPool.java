package com.solvd.laba.dao.pool;

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
    private static String url;
    private static String username;
    private static String password;

    private ConnectionPool() {
        try {// The newInstance() call is a work around for some broken Java implementations
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            LOGGER.info("Driver add successfully");
        } catch (Exception ex) {
            LOGGER.error("Driver connection error");
        }
        loadConfigs();
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public synchronized Connection getConnection() throws SQLException {
        if (createdConAmount < MAX_AMOUNT_OF_CON) {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(url, username, password);
                System.out.println("Connection to Store DB succesfull!");
            } catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
            createdConAmount++;
            sleep(2000);//remove
            return conn;
            //return new Connection();// ?? 'Connection' is abstract; cannot be instantiated
        } else {
            if (!connectionPool.isEmpty()) {
                sleep(2000);//remove
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

    private void sleep(int timeout) {
        try {
            LOGGER.info("TimeOut");
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void loadConfigs(){
        ConfigUtils config = new ConfigUtils();
        url = config.getProperty("url");
        username = config.getProperty("username");
        password = config.getProperty("password");
    }

}


//    public synchronized Connection getConn() throws TimeoutException {
//        if (createdConAmount < MAX_AMOUNT_OF_CON) {
//            createdConAmount++;
//            sleep(20);//remove
//            return null; // ??
//            //return new Connection();// ?? 'Connection' is abstract; cannot be instantiated
//        } else {
//            for (int i = 0; i < 13; i++) {
//                if (i > 0) {
//                    sleep(50);
//                }
//                if (!connectionPool.isEmpty()) {
//                    return connectionPool.remove(0);
//                }
//            }
//            throw new TimeoutException("There was no available conn throw 60 seconds");
//        }
//    }
