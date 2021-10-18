package com.solvd.laba.testNG;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.laba.binary.*;
import com.solvd.laba.dao.jdbc.impl.*;
import com.solvd.laba.service.implementation.jdbc.*;
import kong.unirest.json.JSONException;
import org.apache.commons.io.FileUtils;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.get;


public class SuiteDBTest {
    @Test
    public void carServiceTest() {
        CarServiceImpl carService = new CarServiceImpl();
        Car car = carService.getById(1);
        Assert.assertEquals(car.getCarTypeId(), 1);
    }

    @Test(priority = 1)
    public void driverServiceTest() {
        DriverServiceImpl driverService = new DriverServiceImpl();
        Driver driver = driverService.getById(1);
        Assert.assertEquals(driver.getName(), "Tomas");
        Assert.assertEquals(driver.getPhoneNumber(), "0973020557");
    }

    @Test(priority = 2)
    public void orderServiceTest() {
        OrderServiceImpl orderService = new OrderServiceImpl();
        Order order = orderService.getById(1);
        Assert.assertEquals(order.getOrderId(), 1);
    }

    @Test(priority = 3)
    public void passengerServiceTest() {
        PassengerServiceImpl passengerService = new PassengerServiceImpl();
        Passenger passenger = passengerService.getById(1);
        Assert.assertEquals(passenger.getName(), "Oleg");
    }

    @Test(priority = 4)
    public void streetServiceTest() {
        StreetServiceImpl streetService = new StreetServiceImpl();
        Street street = streetService.getById(1);
        Assert.assertEquals(street.getStreetName(), "Lugovaya");
    }

    @Test(priority = 5)
    public void streetDaoTest() {
        StreetDaoImpl streetDao = new StreetDaoImpl();
        Street street = streetDao.getById(1);
        Assert.assertEquals(street.getNumber(), 65);
    }

    @Test(priority = 6)
    public void orderDaoTest() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        Order expextedOrderRes = new Order();
        expextedOrderRes.setOrderId(1);
        expextedOrderRes.setNumbersOfOrder(1);
        expextedOrderRes.setPrice(0);
        expextedOrderRes.setPassengerId(3);
        expextedOrderRes.setOrderTypeId(3);
        expextedOrderRes.setDriverId(1);
        expextedOrderRes.setCityId(1);
        expextedOrderRes.setStreetId(1);
        expextedOrderRes.setCarId(2);
        Assert.assertEquals(orderDao.getById(1), expextedOrderRes, "This test is failed");
    }

    @Test(priority = 7)
    public void carTypeTest() {
        CarType carType = new CarType();
        carType.setCarTypeName("MiniVAN");
        Assert.assertEquals(carType.getCarTypeName(), "MiniVAN");
    }

    @Test(priority = 8)
    public void cityTest() {
        City city = new City();
        city.setCityName("Kyiv");
        Assert.assertEquals(city.getCityName(), "Kyiv");
    }

    @Test(priority = 9)
    public void orderTypeTest() {
        OrderType orderType = new OrderType();
        orderType.setName("Super class");
        Assert.assertEquals(orderType.getName(), "Super class");
    }

    ObjectMapper objectMapper;

    @BeforeTest
    public void createObjectMapper() {
        objectMapper = new ObjectMapper();
    }


    @Test
    public void jacksonWriteObject() {
        City city = new City();
        city.setCityId(1);
        city.setCityName("Odessa");
        ArrayList<Street> streets = new ArrayList<>();
        Street street1 = new Street();
        street1.setStreetId(3);
        street1.setStreetName("Lugova");
        ArrayList<Driver> drivers = new ArrayList<>();
        Driver driver1 = new Driver();
        driver1.setDriverId(1);
        driver1.setName("Glib");
        driver1.setPhoneNumber("0982240555");
        Driver driver2 = new Driver();
        driver2.setDriverId(2);
        driver2.setName("Tom");
        driver2.setPhoneNumber("0983690580");
        drivers.add(driver1);
        drivers.add(driver2);
        street1.setDrivers(drivers);
        streets.add(street1);
        city.setStreets(streets);

        List<City> cityList = new ArrayList<>();
        cityList.add(city);
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/test/resources/city.json"), cityList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String expJson = FileUtils.readFileToString(new File("src/test/resources/city.json"), StandardCharsets.UTF_8.name());
            String actJson = FileUtils.readFileToString(new File("src/test/resources/city2.json"), StandardCharsets.UTF_8.name());
            JSONAssert.assertEquals(actJson, expJson, JSONCompareMode.STRICT);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jacksonReadObject() {
        try {
            List<City> cityList = objectMapper.readValue(new File("src/test/resources/city2.json"), new TypeReference<List<City>>() {
            });
            Assert.assertEquals(cityList.size(), 1);
            Assert.assertEquals(cityList.get(0).getStreets(), 1);
            Assert.assertEquals(cityList.get(0).getStreets().get(1).getDrivers(), 1);
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
