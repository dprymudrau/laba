package com.solvd.laba.service.implementation.myBatis;

import com.solvd.laba.dao.jdbc.impl.ListOfOrdersDaoImpl;
import com.solvd.laba.service.interfaces.IListOfOrders;
import com.solvd.laba.binary.ListOfOrders;
import com.solvd.laba.utils.myBatis.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ListOfOrdersImpl implements IListOfOrders{
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    @Override
    public ListOfOrders getById(int id) {
        ListOfOrdersDaoImpl listOfOrdersDao = new ListOfOrdersDaoImpl();
        return listOfOrdersDao.getById(id);
    }

    public ListOfOrders getListOfOrdersDAOId (int id){
        ListOfOrders listOfOrders;
        try (SqlSession session = factory.openSession()) {
            IListOfOrders listOfOrdersDAO = session.getMapper(IListOfOrders.class);
            listOfOrders = listOfOrdersDAO.getById(id);
        }
        return listOfOrders;
    }

    @Override
    public void putOrdersToDB(ListOfOrders order) {
        ListOfOrdersDaoImpl listOfOrdersDao = new ListOfOrdersDaoImpl();
        listOfOrdersDao.save(order);
    }
}
