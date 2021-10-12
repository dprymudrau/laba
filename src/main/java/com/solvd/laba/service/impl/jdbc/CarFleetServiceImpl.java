package com.solvd.laba.service.impl.jdbc;

import com.solvd.laba.binary.Car;
import com.solvd.laba.dao.impl.jdbc.CarDAOImpl;
import com.solvd.laba.dao.impl.jdbc.CarFleetDAOImpl;
import com.solvd.laba.util.BelongingException;
import com.solvd.laba.util.UnacceptableCheckResultException;

import java.util.ArrayList;

public class CarFleetServiceImpl extends CarFleetDAOImpl implements CarFleetService<Integer> {


    @Override
    public int countCurrentCarsAmount(Integer carFleetId) {
        CarDAOImpl dao = new CarDAOImpl();
        ArrayList<Car> filteredCars = dao.getAllWithFilter("idCarFleet = " + carFleetId);

        return filteredCars.size();
    }

    @Override
    public boolean checkFreeParkingSlot(Integer carFleetId) {
        CarFleetDAOImpl dao = new CarFleetDAOImpl();
        int carFleetCapacity = dao.getById(carFleetId).getCapacityByCars();
        int amountOfCurrentCars = countCurrentCarsAmount(carFleetId);
        int freeSpace = carFleetCapacity - amountOfCurrentCars;

        return freeSpace > 0;
    }

    @Override
    public boolean doesCarFleetContainCar(Integer carFleetId, Car car) {
        boolean contain = false;
        CarDAOImpl dao = new CarDAOImpl();
        ArrayList<Car> filteredCars = dao.getAllWithFilter("idCarFleet = " + carFleetId);
        for (Car entity : filteredCars) {
            if (entity.getRegNumber().equals(car.getRegNumber())
                && entity.getBrandName().equals(car.getBrandName())
                && entity.getModel().equals(car.getModel())) {
                contain = true;
                break;
            }
        }
        return contain;
    }

    @Override
    public void insertNewCarToFleet(Integer carFleetId, Car newCar) throws UnacceptableCheckResultException {
        if (checkFreeParkingSlot(carFleetId)) {
            if (!doesCarFleetContainCar(carFleetId, newCar)) {
                if (newCar.getIdCarFleet() == carFleetId) {
                    CarDAOImpl dao = new CarDAOImpl();
                    dao.insertToTable(newCar);
                } else throw new BelongingException("This car does not belong to this Car fleet!");
            } else throw new UnacceptableCheckResultException("Car cannot be added.");
        } else throw new UnacceptableCheckResultException("Car cannot be added.");
    }
}
