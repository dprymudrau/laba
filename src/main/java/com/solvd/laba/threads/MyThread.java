package com.solvd.laba.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThread implements Runnable {
    Thread thread;

    private static final Logger LOGGER = LogManager.getLogger();

    public MyThread(String threadName) {
        thread = new Thread(this, threadName);
        thread.start();
    }

    public MyThread() {}


    @Override
    public void run() {
        LOGGER.info(Thread.currentThread().getName());
    }

}
