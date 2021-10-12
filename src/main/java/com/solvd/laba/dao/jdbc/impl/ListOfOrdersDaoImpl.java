package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.Cars;
import com.solvd.laba.binary.ListOfOrders;
import com.solvd.laba.dao.AbstractDAO;
import com.solvd.laba.dao.interfaces.ICarDAO;
import com.solvd.laba.dao.interfaces.IListOfOrdersDAO;
import com.solvd.laba.utils.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListOfOrdersDaoImpl extends AbstractDAO implements IListOfOrdersDAO {

        private static Logger LOGGER = LogManager.getLogger(com.solvd.laba.dao.jdbc.impl.ListOfOrdersDaoImpl.class);

    private static String GET_LISTOFORDERS_BY_ID_Q = "SELECT * FROM ListOfOrders WHERE id = ?";

    private static String PUT_LISTOFORDERS_BY_ID_Q =
                "INSERT INTO ListOfOrders (listOfOrdersId, numbersOfOrder, price, passengerId, orderTypeId, driverId, cityId, streetId, carId)"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public void save(ListOfOrders listOfOrders) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedSt = null;
            ResultSet resultSet = null;
            try {
                preparedSt = connection.prepareStatement(GET_LISTOFORDERS_BY_ID_Q);
                preparedSt.setLong(1, listOfOrders.getListOfOrdersId());
                preparedSt.setLong(2, listOfOrders.getNumbersOfOrder());
                preparedSt.setLong(3, listOfOrders.getPrice());
                preparedSt.setLong(4, listOfOrders.getPassengerId());
                preparedSt.setLong(5, listOfOrders.getOrderTypeId());
                preparedSt.setLong(6, listOfOrders.getDriverId());
                preparedSt.setLong(7, listOfOrders.getCityId());
                preparedSt.setLong(8, listOfOrders.getStreetId());
                preparedSt.setLong(9, listOfOrders.getCarId());
                preparedSt.executeUpdate();

            } catch (SQLException e) {
                LOGGER.error("Error with response", e);
                throw new RuntimeException("");
            } finally {
                ConnectionPool.releaseCon(connection);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(ListOfOrders listOfOrders) {

    }

    @Override
    public void update(ListOfOrders listOfOrders) {

    }

    @Override
        public ListOfOrders getById(long id) {
        ListOfOrders listOfOrders = new ListOfOrders();
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedSt = null;
            ResultSet resultSet = null;
            try {
                preparedSt = connection.prepareStatement(GET_LISTOFORDERS_BY_ID_Q);
                preparedSt.setLong(1, id);
                resultSet = preparedSt.executeQuery();
                if (resultSet.next()) {
                    listOfOrders.setListOfOrdersId((int) resultSet.getLong("1"));
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
            return listOfOrders;
        }
    }

