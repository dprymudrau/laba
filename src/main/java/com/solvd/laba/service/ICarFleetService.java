package com.solvd.laba.service;

import com.solvd.laba.binary.Car;

public interface ICarFleetService<T> {

    int countCurrentCarsAmount(T carFleetId);
    boolean checkFreeParkingSlot(T carFleetId);
    boolean doesCarFleetContainCar(T carFleetId, Car car);
    void insertNewCarToFleet(T carFleetId, Car newCar);
}
