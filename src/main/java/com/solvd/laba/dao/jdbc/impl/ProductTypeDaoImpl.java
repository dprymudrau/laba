package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.ProductType;
import com.solvd.laba.dao.interfaces.ProductTypeDAO;
import com.solvd.laba.dao.jdbc.AbstractDAO;
import com.solvd.laba.utils.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        ProductType productType = new ProductType();
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedSt = null;
        ResultSet resultSet = null;
        try {
            preparedSt = connection.prepareStatement(GET_PRODUCT_TYPE_BY_ID_Q);
            preparedSt.setLong(1, id);
            resultSet = preparedSt.executeQuery();
            if (resultSet.next()) {
                productType.setId((int) resultSet.getLong("ProductType"));
                productType.setName("Name");
            }
            else{
                return null;
            }
        } catch (SQLException e) {
            LOGGER.error("Error with response", e);
            throw new RuntimeException("");
        }
        return productType;
    }
}
