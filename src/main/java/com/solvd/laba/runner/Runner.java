package com.solvd.laba.runner;

import com.solvd.laba.dao.connectionPool.MyConnectionPool;
import com.solvd.laba.dao.connectionPool.MyThread;

public class Runner {
    public static void main(String[] args) {
        MyConnectionPool connections = MyConnectionPool.getInstance();

//        new MyThread("01", connections);
//        new MyThread("02", connections);

        for (int i = 0; i < 50; i++) {
            new MyThread("Thread_№" + (i + 1), connections);
        }


    }
}
