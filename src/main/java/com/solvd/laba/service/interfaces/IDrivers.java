package com.solvd.laba.service.interfaces;

import com.solvd.laba.binary.Drivers;

public interface IDrivers {
    Drivers getById(int id);
    Drivers getDriversDAOId(int id);
}
