package com.solvd.laba.service.jdbc.implementation;

import com.solvd.laba.binary.DeliveryList;
import com.solvd.laba.service.interfaces.IDeliveryList;
import com.solvd.laba.utils.myBatis.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DeliveryListImpl {
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    public DeliveryList getDeliveryListsDAOId (int id){
        DeliveryList deliveryList;
        try (SqlSession session = factory.openSession()) {
            IDeliveryList deliveryListDAO = session.getMapper(IDeliveryList.class);
            deliveryList = (DeliveryList) deliveryListDAO.getById(id);
        }
        return deliveryList;
    }
}
