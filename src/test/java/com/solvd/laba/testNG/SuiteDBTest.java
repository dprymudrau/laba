package com.solvd.laba.testNG;

import com.solvd.laba.binary.*;
import com.solvd.laba.service.implementation.jdbc.*;
import org.testng.annotations.Test;
import org.testng.Assert;

public class SuiteDBTest {

    public class MySuiteDBTests {
        @Test
        public void carServiceTest() {
            CarServiceImpl carService = new CarServiceImpl();
            Car car = carService.getById(1);
            Assert.assertEquals(car.getNumberOfTheCar(), 1);
        }

        public void driverServiceTest(){
            DriverServiceImpl driverService = new DriverServiceImpl();
            Driver driver = driverService.getById(1);
            Assert.assertEquals(driver.getName(), 1);
        }

        public void orderServiceTest(){
            OrderServiceImpl orderService = new OrderServiceImpl();
            Order order = orderService.getById(1);
            Assert.assertEquals(order.getPrice(), 1);
        }

        public void passengerServiceTest(){
            PassengerServiceImpl passengerService = new PassengerServiceImpl();
            Passenger passenger = passengerService.getById(1);
            Assert.assertEquals(passenger.getName(), 1);
        }

        public void streetServiceTest(){
            StreetServiceImpl streetService = new StreetServiceImpl();
            Street street = streetService.getById(1);
            Assert.assertEquals(street.getName(), 1);
        }
    }
}
