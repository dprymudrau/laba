package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.Car;
import com.solvd.laba.dao.AbstractDAO;
import com.solvd.laba.dao.interfaces.CarDAO;
import com.solvd.laba.utils.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

import static org.apache.logging.log4j.core.util.datetime.FixedDateFormat.FixedTimeZoneFormat.HH;

public class CarDaoImpl extends AbstractDAO implements CarDAO {

        private static Logger LOGGER = LogManager.getLogger(CarDaoImpl.class);

        private static String GET_CAR_BY_ID_Q = "SELECT * FROM Car WHERE carId = ?";


    @Override
    public void save(Car car) {
        throw new UnsupportedOperationException("This method isn't implemented");
    }

    @Override
    public void delete(Car car) {
        throw new UnsupportedOperationException("This method isn't implemented");
    }

    @Override
    public void update(Car car) {
        throw new UnsupportedOperationException("This method isn't implemented");
    }

    @Override
        public Car getById(long id) {
            Car car = new Car();
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedSt = null;
            ResultSet resultSet = null;
            try {
                preparedSt = connection.prepareStatement(GET_CAR_BY_ID_Q);
                preparedSt.setLong(1, id);
                resultSet = preparedSt.executeQuery();
                if (resultSet.next()) {
                    car.setCarName("Toyota");
                    car.setCarId(1);
                    car.setCarTypeId(1);
                    car.setNumberOfTheCar(25648);
                    car.setTaxiCompaniesId(1);
                    //car.setDateOfConstruct();
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
            return car;
        }
    }

