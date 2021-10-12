package com.solvd.laba.service.implementation.jdbc;

import com.solvd.laba.binary.ListOfOrders;
import com.solvd.laba.dao.jdbc.impl.ListOfOrdersDaoImpl;
import com.solvd.laba.service.interfaces.IListOfOrders;

public class ListOfOrdersImpl implements IListOfOrders {
    @Override
    public ListOfOrders getById(int id) {
        ListOfOrdersDaoImpl listOfOrdersDao = new ListOfOrdersDaoImpl();
        return listOfOrdersDao.getById(id);
    }

    @Override
    public ListOfOrders getListOfOrdersDAOId(int id) {
        return null;
    }

    @Override
    public void putOrdersToDB(ListOfOrders order) {
        ListOfOrdersDaoImpl listOfOrdersDao = new ListOfOrdersDaoImpl();
        listOfOrdersDao.save(order);
    }
}
