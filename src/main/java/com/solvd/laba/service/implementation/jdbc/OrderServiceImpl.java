package com.solvd.laba.service.implementation.jdbc;

import com.solvd.laba.binary.Order;
import com.solvd.laba.dao.jdbc.impl.ListOfOrdersDaoImpl;
import com.solvd.laba.service.interfaces.IListOfOrders;

public class ListOfOrdersImpl implements IListOfOrders {
    @Override
    public Order getById(int id) {
        ListOfOrdersDaoImpl listOfOrdersDao = new ListOfOrdersDaoImpl();
        return listOfOrdersDao.getById(id);
    }


    @Override
    public void putOrdersToDB(Order order) {
        ListOfOrdersDaoImpl listOfOrdersDao = new ListOfOrdersDaoImpl();
        listOfOrdersDao.save(order);
    }
}
