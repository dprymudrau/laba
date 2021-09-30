package com.solvd.laba.dao.binary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrdersProducts extends Base {
    private static final Logger LOGGER = LogManager.getLogger(OrdersProducts.class);
    private String quantity;
    private String ordersProducts;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getOrdersProducts() {
        return ordersProducts;
    }

    public void setOrdersProducts(String ordersProducts) {
        this.ordersProducts = ordersProducts;
    }

}