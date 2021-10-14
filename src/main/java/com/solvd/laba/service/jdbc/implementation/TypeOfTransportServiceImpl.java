package com.solvd.laba.service.jdbc.implementation;


import com.solvd.laba.binary.TypeOfTransport;
import com.solvd.laba.dao.jdbc.impl.TypeOfTransportDaoImpl;
import com.solvd.laba.service.interfaces.TypeOfTransportService;

public class TypeOfTransportServiceImpl implements TypeOfTransportService {
    @Override
    public TypeOfTransport getTypeOfTransportById(long id) {
        TypeOfTransportDaoImpl typeOfTransportDao = new TypeOfTransportDaoImpl();
        return typeOfTransportDao.getById(id);
    }
}