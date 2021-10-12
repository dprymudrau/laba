package com.solvd.laba.service.implementation.myBatis;

import com.solvd.laba.binary.Orders;
import com.solvd.laba.dao.jdbc.impl.OrderDaoImpl;
import com.solvd.laba.service.interfaces.IOrders;
import com.solvd.laba.utils.myBatis.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class OrdersImpl implements IOrders {
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();


    @Override
    public Orders getById(int id) {
        OrderDaoImpl ordersDao = new OrderDaoImpl();
        return ordersDao.getById(id);
    }

    public Orders getOrdersDAOId (int id){
        Orders orders;
        try (SqlSession session = factory.openSession()) {
            IOrders ordersDAO = session.getMapper(IOrders.class);
            orders = ordersDAO.getById(id);
        }
        return orders;
    }
}
