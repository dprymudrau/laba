package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.Orders;
import com.solvd.laba.dao.AbstractDAO;
import com.solvd.laba.dao.interfaces.IOrdersDAO;
import com.solvd.laba.utils.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

    public class OrderDaoImpl extends AbstractDAO implements IOrdersDAO {

        private static Logger LOGGER = LogManager.getLogger(com.solvd.laba.dao.jdbc.impl.OrderDaoImpl.class);

        private static String GET_ORDER_BY_ID_Q = "SELECT * FROM Order WHERE id = ?";


        @Override
        public void save(Orders orders) {

        }

        @Override
        public void delete(Orders orders) {

        }

        @Override
        public void update(Orders orders) {

        }

        @Override
        public Orders getById(long id) {
            Orders orders = new Orders();
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedSt = null;
            ResultSet resultSet = null;
            try {
                preparedSt = connection.prepareStatement(GET_ORDER_BY_ID_Q);
                preparedSt.setLong(1, id);
                resultSet = preparedSt.executeQuery();
                if (resultSet.next()) {
                    orders.setName("Name");
                    orders.setNumber((int) resultSet.getLong("1"));
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
            return orders;
        }
    }

