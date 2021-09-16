package com.solvd.laba.dao;

public interface EntityDAO<T, U> {// typical database queries
    public void save (T t);
    public void delete (T t);
    T getById(U id);
}
