package com.solvd.laba.service.implementation.jdbc;

import com.solvd.laba.binary.Order;
import com.solvd.laba.dao.jdbc.impl.OrderDaoImpl;
import com.solvd.laba.service.interfaces.OrderService;

public class OrderServiceImpl implements OrderService {
    @Override
    public Order getById(int id) {
        OrderDaoImpl ordersDao = new OrderDaoImpl();
        return ordersDao.getById(id);
    }

    @Override
    public void putOrdersToDB(Order order) {
        OrderDaoImpl listOfOrdersDao = new OrderDaoImpl();
        listOfOrdersDao.save(order);
    }
}
