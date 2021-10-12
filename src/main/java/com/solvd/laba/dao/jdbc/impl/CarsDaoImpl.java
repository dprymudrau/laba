package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.Cars;
import com.solvd.laba.dao.AbstractDAO;
import com.solvd.laba.dao.interfaces.ICarDAO;
import com.solvd.laba.utils.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class CarsDaoImpl extends AbstractDAO implements ICarDAO {

        private static Logger LOGGER = LogManager.getLogger(com.solvd.laba.dao.jdbc.impl.CarsDaoImpl.class);

        private static String GET_CAR_BY_ID_Q = "SELECT * FROM Cars WHERE id = ?";


    @Override
    public void save(Cars cars) {

    }

    @Override
    public void delete(Cars cars) {

    }

    @Override
    public void update(Cars cars) {

    }

    @Override
        public Cars getById(long id) {
            Cars cars = new Cars();
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedSt = null;
            ResultSet resultSet = null;
            try {
                preparedSt = connection.prepareStatement(GET_CAR_BY_ID_Q);
                preparedSt.setLong(1, id);
                resultSet = preparedSt.executeQuery();
                if (resultSet.next()) {
                    cars.setCarName("CarId");
                    cars.setTaxiCompaniesId((int) resultSet.getLong("1"));
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
            return cars;
        }
    }

