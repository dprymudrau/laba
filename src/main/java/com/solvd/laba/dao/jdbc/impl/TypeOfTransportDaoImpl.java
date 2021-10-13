package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.TypeOfTransport;
import com.solvd.laba.dao.interfaces.TypeOfTransportDAO;
import com.solvd.laba.dao.jdbc.AbstractDAO;
import com.solvd.laba.utils.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    }

    @Override
    public TypeOfTransport getById(long id) {
        TypeOfTransport typeOfTransport = new TypeOfTransport();
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedSt = null;
        ResultSet resultSet = null;
        try {
            preparedSt = connection.prepareStatement(GET_TYPE_OF_TRANSPORT_BY_ID_Q);
            preparedSt.setLong(1, id);
            resultSet = preparedSt.executeQuery();
            if (resultSet.next()) {
                typeOfTransport.setId((int) resultSet.getLong(1));
                typeOfTransport.setNumber("Number");
            }
            else{
                return null;
            }
        } catch (SQLException e) {
            LOGGER.error("Error with response", e);
            throw new RuntimeException("");
        }
        return typeOfTransport;
    }
}

