package com.solvd.airport.service.jdbc.implementation;

import com.solvd.airport.binary.Plane;
import com.solvd.airport.dao.jdbc.impl.PlaneDaoImpl;
import com.solvd.airport.service.interfaces.PlaneService;

public class PlaneServiceImpl implements PlaneService {

    @Override
    public Plane getPlaneById(long id) {
        PlaneDaoImpl planeDao = new PlaneDaoImpl();
        return planeDao.getById(id);
    }
}
