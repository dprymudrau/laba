package com.solvd.laba.service.interfaces;

import com.solvd.laba.binary.Streets;

public interface IStreets {
    Streets getById(int id);
    Streets getStreetsDAOId (int id);
}
