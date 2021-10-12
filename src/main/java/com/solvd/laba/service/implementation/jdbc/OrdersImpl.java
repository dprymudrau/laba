package com.solvd.laba.service.implementation.jdbc;

import com.solvd.laba.binary.Orders;
import com.solvd.laba.dao.jdbc.impl.DriversDaoImpl;
import com.solvd.laba.dao.jdbc.impl.OrderDaoImpl;
import com.solvd.laba.service.interfaces.IOrders;

public class OrdersImpl implements IOrders {
    @Override
    public Orders getById(int id) {
        OrderDaoImpl ordersDao = new OrderDaoImpl();
        return ordersDao.getById(id);
    }

    @Override
    public Orders getOrdersDAOId(int id) {
        return null;
    }
}
