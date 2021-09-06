package com.solvd.laba.example;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class BasicConnectionPoolTest {

    @Test
    public void whenCalledgetConnection_thenCorrect() throws SQLException {
        ConnectionPool connectionPool = BasicConnectionPool
                .create("jdbc:h2:mem:test", "user", "password");

        assertTrue(connectionPool.getConnection().isValid(1));
    }
}
