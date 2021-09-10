package com.solvd.laba.example.connections;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Vector;

public class ConnectionPool {
    private Vector<Connection> availableConnections = new Vector<Connection>();
    private Vector<Connection> usedConnections = new Vector<Connection>();

    private String url;

    public ConnectionPool(String url, String driver, int initConnectionsValue) {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.url = url;
        for (int i = 0; i < initConnectionsValue; i++) {
            availableConnections.addElement(getConnection());
        }
    }

    private Connection getConnection() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connect;
    }

    public synchronized Connection retrieve() throws SQLException {
        Connection newConnect = null;
        if (availableConnections.size() == 0) {
            newConnect = getConnection();
        } else {
            newConnect = (Connection) availableConnections.lastElement();
            availableConnections.removeElement(newConnect);
        }
        usedConnections.addElement(newConnect);
        return newConnect;
    }

    public synchronized void putBack(Connection c) throws NullPointerException {
        if (c != null) {
            if (usedConnections.removeElement(c)) {
                availableConnections.addElement(c);
            } else {
                throw new NullPointerException("Connection not in the usedConnections array");
            }
        }
    }

    public int getAvailableConnectionsValue() {
        return availableConnections.size();
    }
}

//    private String url;
//    private String user;
//    private String password;
//    private List<Connection> connectionPool;
//    private List<Connection> usedConnections = new ArrayList<>();
//    private static int initialPoolSize = 5;
//
//    public static ConnectionPool create(String url, String user, String password) throws SQLException {
//        List<Connection> pool = new ArrayList<>(initialPoolSize);
//        for (int i = 0; i < initialPoolSize; i++) {
//            pool.add(createConnection(url, user, password));
//        }
//        return new ConnectionPool(url, user, password, pool);
//    }
//
//    public Connection getConnection() {
//        Connection connection = connectionPool.remove(connectionPool.size() - 1);
//        usedConnections.add(connection);
//        return connection;
//    }
//
//    public boolean releaseConnection(Connection connection) {
//        connectionPool.add(connection);
//        return usedConnections.remove(connection);
//    }
//
//    private static Connection createConnection(String url, String user, String password) throws SQLException {
//        return DriverManager.getConnection(url, user, password);
//    }
//    public int getSize() {
//        return connectionPool.size() + usedConnections.size();
//    }
