package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.TypeOfTransport;
import com.solvd.laba.dao.interfaces.TypeOfTransportDAO;
import com.solvd.laba.dao.jdbc.AbstractDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TypeOfTransportDaoImpl extends AbstractDAO implements TypeOfTransportDAO {

    private static Logger LOGGER = LogManager.getLogger(TypeOfTransportDaoImpl.class);

    private static String GET_TYPE_OF_TRANSPORT_BY_ID_Q = "SELECT typeOfTransport, " +
            "typeOfTransport " +
            "FROM typeOfTransport " +
            "WHERE idTypeOfTransport = ?";



    @Override
    public void save(TypeOfTransport typeOfTransport) {

    }

    @Override
    public void delete(TypeOfTransport typeOfTransport) {

    }}

