package com.solvd.laba.service.impl.myBatis;

import com.solvd.laba.binary.Car;
import com.solvd.laba.binary.CarFleet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CarFleetServiceTest {
    private final static Logger LOGGER = LogManager.getLogger(CarFleetServiceTest.class);

    @Test
    public void getCarFleetByIdTest() {
        CarFleetServiceImpl carFleetService = new CarFleetServiceImpl();
        CarFleet expectedCarFleet = new CarFleet(3, 5);
        CarFleet sqlCarFleet = carFleetService.getCarFleetById(3);
        Assert.assertEquals(sqlCarFleet, expectedCarFleet);
    }

    @Test
    public void countCurrentCarsAmountTest() {
        CarFleetServiceImpl carFleetService = new CarFleetServiceImpl();
        int expectedCarsAmount = 3;
        int sqlCarsAmount = carFleetService.countCurrentCarsAmount(3);
        Assert.assertTrue(sqlCarsAmount == expectedCarsAmount);
    }

    @Test
    public void checkFreeParkingSlotTest() {
        CarFleetServiceImpl carFleetService = new CarFleetServiceImpl();
        int sqlCurrentCarsAmount = carFleetService.countCurrentCarsAmount(3);
        int maxCapacityOfCarFleet = carFleetService.getCarFleetById(3).getCapacityByCars();
        int freeSpaceOfCars = maxCapacityOfCarFleet - sqlCurrentCarsAmount;
        LOGGER.debug(freeSpaceOfCars);
        boolean doHaveFreeSpace = freeSpaceOfCars > 0;
        boolean valueFromSql = carFleetService.checkFreeParkingSlot(3);
        if (doHaveFreeSpace) {
            Assert.assertTrue(valueFromSql);
        } else Assert.assertFalse(valueFromSql);
    }

    @Test
    public void doesCarFleetContainCarTest() {
        CarService carService = new CarService();
        ArrayList<Car> cars = carService.getAll();
        Car carFromCarFleetThree = null;
        for (Car car : cars) {
            if (car.getIdCarFleet() == 3) {
                carFromCarFleetThree = car;
                break;
            }
        }
        CarFleetServiceImpl carFleetService = new CarFleetServiceImpl();
        Assert.assertTrue(carFleetService.doesCarFleetContainCar(3, carFromCarFleetThree));
    }

    @Test
    public void insertNewCarToFleetTest() {
        CarFleetServiceImpl carFleetService = new CarFleetServiceImpl();
        CarService carService = new CarService();
        Car newCar = new Car(100, "TestCar1", "test", "test", 3);
        carFleetService.insertNewCarToFleet(3, newCar);
        ArrayList<Car> currentCars = carService.getAll();
        boolean doHaveCar = false;
        for (Car car : currentCars) {
            if (newCar.equals(car)) {
                doHaveCar = true;
                break;
            }
        }
        Assert.assertTrue(doHaveCar);
    }
}
