package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.OrdersProducts;
import com.solvd.laba.dao.interfaces.OrderProductsDAO;
import com.solvd.laba.dao.jdbc.AbstractDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


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
        return null;
    }


}
