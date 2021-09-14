package com.solvd.laba.runner;

import com.solvd.laba.dao.connectionPool.MyConnectionPool;
import com.solvd.laba.dao.connectionPool.MyThread;

public class Runner {
    public static void main(String[] args) {
        MyConnectionPool connections = MyConnectionPool.getInstance();

        new MyThread("01", connections);
        new MyThread("02", connections);
        new MyThread("03", connections);
        new MyThread("04", connections);
        new MyThread("05", connections);
        new MyThread("06", connections);


    }
}
