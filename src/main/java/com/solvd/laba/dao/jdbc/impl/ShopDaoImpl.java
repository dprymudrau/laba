package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.Shop;
import com.solvd.laba.dao.interfaces.ShopDAO;
import com.solvd.laba.dao.jdbc.AbstractDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShopDaoImpl extends AbstractDAO implements ShopDAO {

    private static Logger LOGGER = LogManager.getLogger(ShopDaoImpl.class);

    private static String GET_SHOP_BY_ID_Q = "SELECT * FROM Shop WHERE id = ?";

    @Override
    public void save(Shop shop) {

    }

    @Override
    public void delete(Shop shop) {

    }
}
