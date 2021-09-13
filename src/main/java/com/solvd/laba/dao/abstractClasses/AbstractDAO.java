package com.solvd.laba.dao.abstractClasses;

import com.solvd.laba.dao.connectionPool.MyConnectionPool;
import com.solvd.laba.example.connections.Connection;

import java.sql.SQLException;

public abstract class AbstractDAO {
    protected MyConnectionPool connections = MyConnectionPool.getInstance();

    public abstract Connection getConnection() throws SQLException;

    public abstract void releaseConnection(Connection connection);
}
