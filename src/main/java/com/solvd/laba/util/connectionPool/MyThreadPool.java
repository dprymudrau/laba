package com.solvd.laba.util.connectionPool;

import java.sql.SQLException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

public class MyThreadPool implements Executor {
    private final Queue<MyThread> workQueue = new ConcurrentLinkedQueue<>();
    private volatile boolean isRunning = true;

    public MyThreadPool(int size) throws SQLException {
        String name = "Thread_№";
        for (int i = 0; i < size; i++) {
            new MyThread(name + (i + 1), MyConnectionPool.getInstance());
        }
    }

    public boolean getIsRunning() {
        return isRunning;
    }

    @Override
    public void execute(Runnable runnable) {

    }


    private final class TaskWorker extends MyThread implements Runnable {

        public TaskWorker(String threadName, MyConnectionPool connectionPool) throws SQLException {
            super(threadName, connectionPool);
        }

        @Override
        public void run() {
            while (MyThreadPool.this.isRunning) {
                MyThread nextTask = workQueue.poll();
                if (nextTask != null) {
                    nextTask.run();
                }
            }
        }
    }
}
