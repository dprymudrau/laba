package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.Street;
import com.solvd.laba.dao.AbstractDAO;
import com.solvd.laba.dao.interfaces.IStreetDAO;
import com.solvd.laba.utils.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StreetsDaoImpl extends AbstractDAO implements IStreetDAO {


        private static Logger LOGGER = LogManager.getLogger(com.solvd.laba.dao.jdbc.impl.StreetsDaoImpl.class);

        private static String GET_STREETS_BY_ID_Q = "SELECT * FROM Streets WHERE id = ?";


    @Override
    public void save(Street street) {

    }

    @Override
    public void delete(Street street) {

    }

    @Override
    public void update(Street street) {

    }

    @Override
        public Street getById(long id) {
            Street street = new Street();
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedSt = null;
            ResultSet resultSet = null;
            try {
                preparedSt = connection.prepareStatement(GET_STREETS_BY_ID_Q);
                preparedSt.setLong(1, id);
                resultSet = preparedSt.executeQuery();
                if (resultSet.next()) {
                    street.setName("Name");
                    street.setStreetId((int) resultSet.getLong("1"));
                }
                else{
                    return null;
                }
            } catch (SQLException e) {
                LOGGER.error("Error with response", e);
                throw new RuntimeException("");
            } finally {
                ConnectionPool.releaseCon(connection);
            }
            return street;
        }
    }


