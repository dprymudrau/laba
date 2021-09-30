package com.solvd.airport.dao;

import com.solvd.airport.utils.ConnectionPool;

public abstract class AbstractDAO {

    public ConnectionPool connectionPool = ConnectionPool.getInstance();

    /*public Connection getConnection() throws InterruptedException {
        connectionPool.getConnection();
    }
    public void releaseC*/


}
