package com.solvd.laba;

import com.solvd.laba.dao.abClasses.Adress;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Main{
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

//        for(int i=1; i < 10; i++){
//            new Threads("Thread"+i).start();
//
//        }
        Adress adress;
        new Adress.getSmth();
    }
}
