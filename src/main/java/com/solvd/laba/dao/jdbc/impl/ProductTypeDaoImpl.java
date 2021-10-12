package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.ProductType;
import com.solvd.laba.dao.interfaces.ProductTypeDAO;
import com.solvd.laba.dao.jdbc.AbstractDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductTypeDaoImpl extends AbstractDAO implements ProductTypeDAO {

    private static Logger LOGGER = LogManager.getLogger(ProductTypeDaoImpl.class);

    private static String GET_PRODUCT_TYPE_BY_ID_Q = "SELECT idProductType, " +
            "productType " +
            "FROM productType " +
            "WHERE idProductType = ?";


    @Override
    public void save(ProductType productType) {

    }

    @Override
    public void delete(ProductType productType) {

    }

    @Override
    public ProductType getById(long id) {
        return null;
    }
}
