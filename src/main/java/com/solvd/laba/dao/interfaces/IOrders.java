package com.solvd.laba.dao.interfaces;

import java.util.List;

public interface IOrders<F> {
    public List<String> getOrdersByCarID (long id);
}
