package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.Driver;
import com.solvd.laba.dao.AbstractDAO;
import com.solvd.laba.dao.interfaces.DriverDAO;
import com.solvd.laba.utils.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DriverDaoImpl extends AbstractDAO implements DriverDAO {

        private static Logger LOGGER = LogManager.getLogger(DriverDaoImpl.class);

        private static String GET_DRIVERS_BY_ID_Q = "SELECT * FROM Driver WHERE driverId = ?";


    @Override
    public void save(Driver driver) {
        throw new UnsupportedOperationException("This method isn't implemented");

    }

    @Override
    public void delete(Driver driver) {
        throw new UnsupportedOperationException("This method isn't implemented");

    }

    @Override
    public void update(Driver driver) {
        throw new UnsupportedOperationException("This method isn't implemented");
    }

    @Override
        public Driver getById(long id) {
        Driver driver = new Driver();
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedSt = null;
            ResultSet resultSet = null;
            try {
                preparedSt = connection.prepareStatement(GET_DRIVERS_BY_ID_Q);
                preparedSt.setLong(1, id);
                resultSet = preparedSt.executeQuery();
                if (resultSet.next()) {
                    driver.setDriverId(1);
                    driver.setName("Name");
                    driver.setPhoneNumber(2653);
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
            return driver;
        }
    }
