package com.solvd.laba.service.implementation.myBatis;

import com.solvd.laba.dao.jdbc.impl.ListOfOrdersDaoImpl;
import com.solvd.laba.service.interfaces.IListOfOrders;
import com.solvd.laba.binary.Order;
import com.solvd.laba.utils.myBatis.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ListOfOrdersImpl implements IListOfOrders{
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    @Override
    public Order getById(int id) {
        Order order;
        try (SqlSession session = factory.openSession()) {
            IListOfOrders listOfOrdersDAO = session.getMapper(IListOfOrders.class);
            order = listOfOrdersDAO.getById(id);
        }
        return order;
    }



    @Override
    public void putOrdersToDB(Order order) {
        ListOfOrdersDaoImpl listOfOrdersDao = new ListOfOrdersDaoImpl();
        listOfOrdersDao.save(order);
    }
}
