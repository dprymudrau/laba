package com.solvd.laba.service;

import com.solvd.laba.dao.interfaces.IListOfOrders;
import com.solvd.laba.binary.ListOfOrders;
import com.solvd.laba.utils.myBatis.MyBatis;

public class ListOfOrdersImpl {
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    public ListOfOrders getListOfOrdersImplDAOId (int id){
        ListOfOrders listOfOrders;
        try (SqlSession session = factory.openSession()) {
            IListOfOrders listOfOrdersDAO = session.getMapper(IListOfOrders.class);
            listOfOrders = listOfOrdersDAO.getById(id);
        }
        return listOfOrders;
    }
}
