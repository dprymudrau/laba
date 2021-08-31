package com.solvd.laba.threads.connections;

public final class ConnectionPoolSample {
    private static volatile ConnectionPoolSample instance = null;

    private ConnectionPoolSample() {}

    public static ConnectionPoolSample getInstance() {
        if (instance == null) {
            synchronized (ConnectionPoolSample.class) {
                if (instance == null) {
                    instance = new ConnectionPoolSample();
                }
            }
        }
        return instance;
    }

}
