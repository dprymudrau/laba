package com.solvd.laba.service.interfaces;

import com.solvd.laba.binary.Order;

public interface OrderService {
    Order getById(int id);
    void putOrdersToDB(Order order);
}
