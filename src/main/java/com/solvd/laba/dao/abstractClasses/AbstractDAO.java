package com.solvd.laba.dao.abstractClasses;

import com.solvd.laba.dao.pool.Connection;
import com.solvd.laba.dao.pool.ConnectionPool;

public class AbstractDAO {
    public Connection getConnection(){
        return ConnectionPool.getInstance().getConnection();
    }
}
