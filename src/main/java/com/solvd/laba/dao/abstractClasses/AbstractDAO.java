package com.solvd.laba.dao.abstractClasses;

import com.solvd.laba.util.connectionPool.MyConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

public abstract class AbstractDAO <T> {
    private MyConnectionPool pool = MyConnectionPool.getInstance();

    private static final Logger LOGGER = LogManager.getLogger(AbstractDAO.class);

    protected Connection getConnection() {
        try {
            return pool.retrieve();
        } catch (InterruptedException | SQLException | TimeoutException e) {
            LOGGER.error(e);
            LOGGER.error("Null is returned!");
        }
        return null;
    }

    protected void releaseConnection(Connection connection) {
        pool.putBack(connection);
    }

    protected abstract void executeQuery(String query);
}
