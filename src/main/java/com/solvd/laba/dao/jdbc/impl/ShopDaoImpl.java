package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.Shop;
import com.solvd.laba.dao.interfaces.ShopDAO;
import com.solvd.laba.dao.jdbc.AbstractDAO;
import com.solvd.laba.utils.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopDaoImpl extends AbstractDAO implements ShopDAO {

    private static Logger LOGGER = LogManager.getLogger(ShopDaoImpl.class);

    private static String GET_SHOP_BY_ID_Q = "SELECT * FROM Shop WHERE id = ?";

    @Override
    public void save(Shop shop) {

    }

    @Override
    public void delete(Shop shop) {

    }

    @Override
    public Shop getById(long id) {
        Shop shop = new Shop();
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedSt = null;
        ResultSet resultSet = null;
        try {
            preparedSt = connection.prepareStatement(GET_SHOP_BY_ID_Q);
            preparedSt.setLong(1, id);
            resultSet = preparedSt.executeQuery();
            if (resultSet.next()) {
                shop.setId((int) resultSet.getLong(1));
                shop.setAdress("Name");
            }
            else{
                return null;
            }
        } catch (SQLException e) {
            LOGGER.error("Error with response", e);
            throw new RuntimeException("");
        }
        return shop;
    }


}
