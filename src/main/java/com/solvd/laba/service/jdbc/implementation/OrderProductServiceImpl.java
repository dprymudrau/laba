package com.solvd.laba.service.jdbc.implementation;


import com.solvd.laba.binary.OrdersProducts;
import com.solvd.laba.dao.jdbc.impl.OrderProductDaoImpl;

public class OrderProductServiceImpl {
    public void putOrderProductToDB(OrdersProducts ordersProducts) {
        OrderProductDaoImpl orderProductDao = new OrderProductDaoImpl();
        orderProductDao.save(ordersProducts);
    }
}
