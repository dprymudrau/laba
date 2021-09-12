package com.solvd.laba;

import com.solvd.laba.poJo.Adress;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Main{
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Adress a = new Adress();
        LOGGER.info(a.toString());
        LOGGER.info(a.equals(a));
        LOGGER.info(a.hashCode());
        int i = 4;
//        for(int i=1; i < 10; i++){
//            new Threads("Thread"+i).start();
//
//        }

    }
}
