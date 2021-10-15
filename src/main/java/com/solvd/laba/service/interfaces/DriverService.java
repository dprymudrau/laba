package com.solvd.laba.service.interfaces;

import com.solvd.laba.binary.Driver;

public interface IDrivers {
    Driver getById(int id);
    Driver getDriversDAOId(int id);
}
