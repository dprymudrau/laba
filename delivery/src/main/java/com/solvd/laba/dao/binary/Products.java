package com.solvd.laba.dao.binary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Products extends Base{
    private static final Logger LOGGER = LogManager.getLogger(Products.class);
    private String menuName;
    private int price;

    public String getMenuName() {
        return menuName;
    }
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
   }
