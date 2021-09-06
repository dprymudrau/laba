package com.solvd.laba.dao.abstractClasses;

import com.solvd.laba.threads.connections.Connection;

public abstract class AbstractDAO {

    public abstract Connection getConnection();

    public abstract void releaseConnection(Connection connection);
}
