package com.solvd.laba.service.jdbc.implementation;

import com.solvd.laba.binary.Supplier;
import com.solvd.laba.service.interfaces.ISupplier;
import com.solvd.laba.utils.myBatis.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class SupplierImpl {
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    public Supplier getSuppliersDAOId (int id){
        Supplier supplier;
        try (SqlSession session = factory.openSession()) {
            ISupplier supplierDAO = session.getMapper(ISupplier.class);
            supplier = (Supplier) supplierDAO.getById(id);
        }
        return supplier;
    }
}
