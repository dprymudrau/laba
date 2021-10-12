package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.Drivers;
import com.solvd.laba.dao.AbstractDAO;
import com.solvd.laba.dao.interfaces.IDriverDAO;
import com.solvd.laba.utils.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DriversDaoImpl extends AbstractDAO implements IDriverDAO {

        private static Logger LOGGER = LogManager.getLogger(com.solvd.laba.dao.jdbc.impl.DriversDaoImpl.class);

        private static String GET_DRIVERS_BY_ID_Q = "SELECT * FROM Drivers WHERE id = ?";


    @Override
    public void save(Drivers drivers) {

    }

    @Override
    public void delete(Drivers drivers) {

    }

    @Override
    public void update(Drivers drivers) {

    }

    @Override
        public Drivers getById(long id) {
        Drivers driver = new Drivers();
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedSt = null;
            ResultSet resultSet = null;
            try {
                preparedSt = connection.prepareStatement(GET_DRIVERS_BY_ID_Q);
                preparedSt.setLong(1, id);
                resultSet = preparedSt.executeQuery();
                if (resultSet.next()) {
                    driver.setId((int) resultSet.getLong("DriverId"));
                    driver.setName("Name");
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
