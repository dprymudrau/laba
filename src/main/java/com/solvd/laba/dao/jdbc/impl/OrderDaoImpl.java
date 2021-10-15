package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.Order;
import com.solvd.laba.dao.AbstractDAO;
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

    private static String GET_LISTOFORDERS_BY_ID_Q = "SELECT * FROM ListOfOrders WHERE listOfOrdersId = ?";

    private static String PUT_LISTOFORDERS_BY_ID_Q =
                "INSERT INTO ListOfOrders (listOfOrdersId, numbersOfOrder, price, passengerId, orderTypeId, driverId, cityId, streetId, carId)"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public void save(Order order) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedSt = null;
            ResultSet resultSet = null;
            try {
                preparedSt = connection.prepareStatement(GET_LISTOFORDERS_BY_ID_Q);
                preparedSt.setLong(1, order.getListOfOrdersId());
                preparedSt.setLong(2, order.getNumbersOfOrder());
                preparedSt.setLong(3, order.getPrice());
                preparedSt.setLong(4, order.getPassengerId());
                preparedSt.setLong(5, order.getOrderTypeId());
                preparedSt.setLong(6, order.getDriverId());
                preparedSt.setLong(7, order.getCityId());
                preparedSt.setLong(8, order.getStreetId());
                preparedSt.setLong(9, order.getCarId());
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
    public void delete(Order order) {

    }

    @Override
    public void update(Order order) {

    }

    @Override
        public Order getById(long id) {
        Order order = new Order();
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedSt = null;
            ResultSet resultSet = null;
            try {
                preparedSt = connection.prepareStatement(GET_LISTOFORDERS_BY_ID_Q);
                preparedSt.setLong(1, id);
                resultSet = preparedSt.executeQuery();
                if (resultSet.next()) {
                    order.setListOfOrdersId((int) resultSet.getLong(1));
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
            return order;
        }
    }

