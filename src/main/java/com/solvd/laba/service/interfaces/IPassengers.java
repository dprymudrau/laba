package com.solvd.laba.service.interfaces;

import com.solvd.laba.binary.Passenger;

public interface IPassengers {
    Passenger getById(int id);
    Passenger getPassengerDAOId (int id);
}
