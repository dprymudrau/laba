package com.solvd.laba.threads.connections;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {
    private boolean authorization;
    private static final Logger LOGGER = LogManager.getLogger(Connection.class);

    public Connection() {}

    public void pingDB() {
        LOGGER.info("Make ping of DB");
    }

    public void AuthorizationInBD(String name) {
        if (name.equals("Jeka") || name.equals("Dmitriy")) {
            authorization = true;
        }
        LOGGER.info("Authorization... " + authorization);
    }

    public String getInfoBD() {
        return "Some info...";
    }

    public void executeQuery() {
        LOGGER.info("Query is running...");
    }

    public void close() {
        LOGGER.info("Connection is closed");
    }
}
