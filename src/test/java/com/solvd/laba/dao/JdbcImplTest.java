package com.solvd.laba.dao;

import com.solvd.laba.binary.Car;
import com.solvd.laba.dao.impl.jdbc.CarDAOImpl;
import com.solvd.laba.dao.interfaces.ICarDAO;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;


public class JdbcImplTest {
    private static final ArrayList<Car> expectedSetOfCars = new ArrayList<>() {
        {
            add(new Car(1, "Ford", "Tranzit", "5326PA-7", 1));
            add(new Car(2, "Mercedes-Benz", "Sprinter", "2005TE-7", 2));
            add(new Car(3, "GAZ", "32214 \"Gazel\"", "6351TE-7", 3));
            add(new Car(4, "GAZ", "2217 \"Sobol\"", "4236BC-7", 2));
            add(new Car(5, "Peugeot", "Boxer", "0957KC-7", 2));
            add(new Car(6, "UAZ", "452", "1488MH-7", 3));
            add(new Car(7, "BMW", "X5", "1580HM-7", 3));
        }
    };

    @Test
    public void getAllTest() {
        ICarDAO carDAO = new CarDAOImpl();
        SoftAssert sAssert = new SoftAssert();
        ArrayList<Car> carsFromSQL = carDAO.getAll();
        sAssert.assertEquals(carsFromSQL, expectedSetOfCars);
        sAssert.assertEquals(carsFromSQL.size(), expectedSetOfCars.size());
        sAssert.assertAll();
    }

    @Test
    public void getAllByCarFleetIdTest() {
        ICarDAO carDAO = new CarDAOImpl();
        SoftAssert sAssert = new SoftAssert();
        ArrayList<Car> expectedCars = new ArrayList<>() {
            {
                add(new Car(3, "GAZ", "32214 \"Gazel\"", "6351TE-7", 3));
                add(new Car(6, "UAZ", "452", "1488MH-7", 3));
                add(new Car(7, "BMW", "X5", "1580HM-7", 3));
            }
        };
        ArrayList<Car> carsFromSQL = carDAO.getAllByCarFleetId(3);
        sAssert.assertEquals(carsFromSQL, expectedCars);
        sAssert.assertEquals(carsFromSQL.size(), expectedCars.size());
        sAssert.assertAll();
    }

    @Test
    public void getByIdTest() {
        ICarDAO carDAO = new CarDAOImpl();
        Car expectedCar = new Car(2, "Mercedes-Benz", "Sprinter", "2005TE-7", 2);
        Car sqlCar = carDAO.getById(2);
        Assert.assertEquals(sqlCar, expectedCar);
    }

    @Test
    public void insertToTableTest() {
        ICarDAO carDAO = new CarDAOImpl();
        Car testCar = new Car(99, "MyTestCar", "Testing", "Testing", 1);
        carDAO.insertToTable(testCar);
        Car testBackCar = carDAO.getById(99);
        Assert.assertEquals(testBackCar, testCar);
    }

    @Test
    public void deleteByIdTest() {
        ICarDAO carDAO = new CarDAOImpl();
        ArrayList<Car> beforeDeletingCars = carDAO.getAll();
        if (beforeDeletingCars.size() != 8) {
            carDAO.insertToTable(new Car(99, "MyTestCar", "Testing", "Testing", 1));
            beforeDeletingCars = carDAO.getAll();
        }
        carDAO.deleteById(99);
        ArrayList<Car> afterDeletingCars = carDAO.getAll();
        Assert.assertFalse(afterDeletingCars.size() == beforeDeletingCars.size());
        Assert.assertEquals(afterDeletingCars, expectedSetOfCars);
    }

    @Test
    public void deleteByFilter() {
        ICarDAO carDAO = new CarDAOImpl();
        Car newCar = new Car(77, "TestCar", "Testing", "Testing", 3);
        carDAO.insertToTable(newCar);
        ArrayList<Car> beforeDeletingCarsWithNewOne = carDAO.getAll();
        carDAO.deleteByFilter("carBrandName = 'TestCar' LIMIT 1");
        ArrayList<Car> afterDeletingCars = carDAO.getAll();
        Assert.assertFalse(afterDeletingCars.size() == beforeDeletingCarsWithNewOne.size());
        Assert.assertEquals(afterDeletingCars, expectedSetOfCars);
    }

    @Test
    public void updateEntityRowTest() {
        ICarDAO carDAO = new CarDAOImpl();
        Car car1 = new Car(100, "TestCar", "Testing", "Testing", 2);
        carDAO.insertToTable(car1);
        car1.setBrandName("TestCar2ndEdit");
        carDAO.updateEntityRow(car1);
        Car carSQL = carDAO.getById(100);
        Car expectedCar = new Car(100, "TestCar", "Testing", "Testing", 2);
        Assert.assertFalse(expectedCar.equals(carSQL));
        carDAO.deleteById(100);
    }
}
