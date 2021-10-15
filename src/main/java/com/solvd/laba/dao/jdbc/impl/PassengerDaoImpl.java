package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.Passenger;
import com.solvd.laba.dao.AbstractDAO;
import com.solvd.laba.dao.interfaces.PassengerDAO;
import com.solvd.laba.utils.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerDaoImpl extends AbstractDAO implements PassengerDAO {

        private static Logger LOGGER = LogManager.getLogger(com.solvd.laba.dao.jdbc.impl.PassengerDaoImpl.class);

        private static String GET_PASSENGER_BY_ID_Q = "SELECT * FROM Passenger WHERE passengerId = ?";

    @Override
    public void save(Passenger passenger) {
        throw new UnsupportedOperationException("This method isn't implemented");

    }

    @Override
    public void delete(Passenger passenger) {
        throw new UnsupportedOperationException("This method isn't implemented");

    }

    @Override
    public void update(Passenger passenger) {
        throw new UnsupportedOperationException("This method isn't implemented");

    }

    @Override
        public Passenger getById(long id) {
        Passenger passenger = new Passenger();
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedSt = null;
            ResultSet resultSet = null;
            try {
                preparedSt = connection.prepareStatement(GET_PASSENGER_BY_ID_Q);
                preparedSt.setLong(1, id);
                resultSet = preparedSt.executeQuery();
                if (resultSet.next()) {
                    passenger.setName("Name");
                    passenger.setId(1);
                    passenger.setPhoneNumber("0953045512");
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
            return passenger;
        }
    }
