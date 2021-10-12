package com.solvd.laba.service.interfaces;

import com.solvd.laba.binary.Orders;

public interface IOrders {
    Orders getById(int id);
    Orders getOrdersDAOId (int id);
}
