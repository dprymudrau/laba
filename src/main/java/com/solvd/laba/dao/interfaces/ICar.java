package com.solvd.laba.dao.interfaces;

import com.solvd.laba.binary.Cars;
import com.solvd.laba.dao.IEntityDAO;
import com.solvd.laba.binary.CarType;

public interface ICar  extends IEntityDAO<CarType> {
    void delete(Cars cars);
}

