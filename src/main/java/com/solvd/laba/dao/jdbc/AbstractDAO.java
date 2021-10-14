package com.solvd.laba.dao.jdbc;


import com.solvd.laba.utils.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class AbstractDAO {
    private static final Logger LOGGER = LogManager.getLogger(AbstractDAO.class);

    public ConnectionPool connectionPool = ConnectionPool.getInstance();
}
