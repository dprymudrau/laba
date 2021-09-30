package com.solvd.airport.service.jdbc.implementation;

import com.solvd.airport.binary.PlaneModel;
import com.solvd.airport.dao.jdbc.impl.PlaneModelDaoImpl;
import com.solvd.airport.service.interfaces.PlaneModelService;

public class PlaneModelServiceImpl implements PlaneModelService {
    @Override
    public PlaneModel getPlaneModelById(long id) {
        PlaneModelDaoImpl planeModelDao = new PlaneModelDaoImpl();
        return planeModelDao.getById(id);
    }
}
