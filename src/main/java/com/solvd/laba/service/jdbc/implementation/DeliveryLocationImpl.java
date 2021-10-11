package com.solvd.laba.service.jdbc.implementation;

import com.solvd.laba.binary.DeliveryLocation;
import com.solvd.laba.service.interfaces.IDeliveryLocation;
import com.solvd.laba.utils.myBatis.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DeliveryLocationImpl {
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    public DeliveryLocation getDeliveryLocationsDAOId (int id){
        DeliveryLocation deliveryLocation;
        try (SqlSession session = factory.openSession()) {
            IDeliveryLocation deliveryLocationDAO = session.getMapper(IDeliveryLocation.class);
            deliveryLocation = deliveryLocationDAO.getById(id);
        }
        return deliveryLocation;
    }
}
