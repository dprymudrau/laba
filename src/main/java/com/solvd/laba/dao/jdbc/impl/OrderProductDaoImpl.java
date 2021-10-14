package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.OrdersProducts;
import com.solvd.laba.dao.interfaces.OrderProductsDAO;
import com.solvd.laba.dao.jdbc.AbstractDAO;
import com.solvd.laba.utils.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderProductDaoImpl extends AbstractDAO implements OrderProductsDAO {

    private static Logger LOGGER = LogManager.getLogger(OrderProductDaoImpl.class);

    private static String GET_ORDER_PRODUCT_BY_ID_Q = "SELECT * FROM OrderProduct WHERE id = ?";


    @Override
    public void save(OrdersProducts ordersProducts) {

    }

    @Override
    public void delete(OrdersProducts ordersProducts) {

    }

    @Override
    public OrdersProducts getById(long id) {
        OrdersProducts ordersProducts = new OrdersProducts();
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedSt = null;
        ResultSet resultSet = null;
        try {
            preparedSt = connection.prepareStatement(GET_ORDER_PRODUCT_BY_ID_Q);
            preparedSt.setLong(1, id);
            resultSet = preparedSt.executeQuery();
            if (resultSet.next()) {
                ordersProducts.setId((int) resultSet.getLong(1));
                ordersProducts.setOrdersProducts("Name");
            }
            else{
                return null;
            }
        } catch (SQLException e) {
            LOGGER.error("Error with response", e);
            throw new RuntimeException("");
        }
        return ordersProducts;
    }


}
