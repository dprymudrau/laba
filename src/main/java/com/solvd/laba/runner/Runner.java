package com.solvd.laba.runner;

import com.solvd.laba.binary.Car;
import com.solvd.laba.dao.impl.jdbc.CarDAOImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
//        MyConnectionPool connections = MyConnectionPool.getInstance();
//
//        new MyThread("01", connections);
//        new MyThread("02", connections);
//        new MyThread("03", connections);
//        new MyThread("04", connections);
//        new MyThread("05", connections);
//        new MyThread("06", connections);

        CarDAOImpl carDAO = new CarDAOImpl();
        carDAO.printAll();
        carDAO.printByFilter("idCarFleet = 3");
        System.out.println();

        ArrayList<Car> cars = carDAO.getAll();
        cars.forEach(System.out::println);
        System.out.println();

        ArrayList<Car> anotherCars = carDAO.getAllWithFilter("carBrandName = 'GAZ'");
        anotherCars.forEach(System.out::println);
        System.out.println();

        Car car = carDAO.getById(2);
        LOGGER.info(car);
        System.out.println();

//        Car myCar = new Car(99, "BMW", "X6", "7777OC-7", 3);
//        carDAO.insertToTable(myCar);
        carDAO.printAll();
        carDAO.deleteAllByFilter("carBrandName = 'BMW'");
        carDAO.printAll();
    }
}
