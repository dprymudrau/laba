package com.solvd.laba.service.interfaces;

import com.solvd.laba.binary.ListOfOrders;

public interface IListOfOrders {
    ListOfOrders getById(int id);
    ListOfOrders getListOfOrdersDAOId (int id);
    void putOrdersToDB(ListOfOrders order);
}
