package com.solvd.hospital.others;

import com.solvd.hospital.exception.TimeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;

class JThread {
    private static final Logger LOGGER = LogManager.getLogger(JThread.class);
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    public static void main(String[] args) {

        ArrayList<Thread> threads = new ArrayList<>();


        LOGGER.info("Main thread started...");
        Runnable r = ()->{
            LOGGER.info("started... \n");
            Random random = new Random();
            try{
                Thread.sleep(random.nextInt(800)+200);
                while(!connectionPool.checkForConnections()){
                    LOGGER.info(Thread.currentThread().getName()+" is waiting");
                    Thread.sleep(100);
                }
                Connection connection = connectionPool.getConnection();
                connection.open(Thread.currentThread().getName());
                connection.authBD(Thread.currentThread().getName());
                connection.pingBD(Thread.currentThread().getName());
                connection.infoBD(Thread.currentThread().getName());
                connection.executeQuery(Thread.currentThread().getName());
                connection.close(Thread.currentThread().getName());
                Thread.sleep(random.nextInt(800)+200);
                connectionPool.releaseConnection(connection);
            }
            catch(InterruptedException e){
                LOGGER.error("Thread has been interrupted");
            }
            catch (TimeException e){
                LOGGER.error(e.getMessage());
            }
            LOGGER.info("finished... \n");
        };
        for (int i=0; i<8;i++){
            threads.add(new Thread(r, "thread "+ i));
            threads.get(i).start();
        }
        LOGGER.info("Main thread finished...");

    }

}