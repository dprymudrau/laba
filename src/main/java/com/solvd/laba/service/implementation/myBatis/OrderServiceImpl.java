package com.solvd.laba.service.implementation.myBatis;

import com.solvd.laba.dao.jdbc.impl.OrderDaoImpl;
import com.solvd.laba.service.interfaces.OrderService;
import com.solvd.laba.binary.Order;
import com.solvd.laba.utils.myBatis.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class OrderServiceImpl implements OrderService {
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    @Override
    public Order getById(int id) {
        Order order;
        try (SqlSession session = factory.openSession()) {
            OrderService listOfOrdersDAO = session.getMapper(OrderService.class);
            order = listOfOrdersDAO.getById(id);
        }
        return order;
    }

    @Override
    public void putOrdersToDB(Order order) {
        OrderDaoImpl listOfOrdersDao = new OrderDaoImpl();
        listOfOrdersDao.save(order);
    }
}
