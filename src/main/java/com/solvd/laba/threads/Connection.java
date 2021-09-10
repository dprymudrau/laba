package com.solvd.laba.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {
    private static final Logger LOGGER = LogManager.getLogger(Connection.class);

    public Connection() {
    }

    public void open(String threadName) {
        LOGGER.info(threadName+" open connection");
    }

    public void pingBD(String threadName) {
        LOGGER.info(threadName + " ping");
    }

    public void authBD(String threadName) {
        LOGGER.info(threadName+ " authorization");
    }

    public void infoBD(String threadName) {
        LOGGER.info("Info: "+ threadName+ " connection");
    }

    public void executeQuery(String threadName) {
        LOGGER.info(threadName+"implementatiom");
    }

    public void close(String threadName) {
        LOGGER.info(threadName + "closed");
    }

}
