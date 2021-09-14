package com.solvd.laba.dao.pool.exeptions;

public class ConnectionExeption extends RuntimeException {
    public ConnectionExeption(String message) {
        super(message);
    }
}

