package com.solvd.laba.dao;

import com.solvd.laba.utils.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;


public abstract class AbstractDAO {
    private static final Logger LOGGER = LogManager.getLogger(AbstractDAO.class);

    public Connection getConnection() {
        return ConnectionPool.getInstance().getConnection();
    }

    public void returnConnection(Connection connection) {
        ConnectionPool.getInstance().releaseCon(connection);
    }

    public void closeResourse(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
