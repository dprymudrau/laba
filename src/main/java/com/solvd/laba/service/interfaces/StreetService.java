package com.solvd.laba.service.interfaces;

import com.solvd.laba.binary.Street;

public interface IStreets {
    Street getById(int id);
    Street getStreetsDAOId (int id);
}
