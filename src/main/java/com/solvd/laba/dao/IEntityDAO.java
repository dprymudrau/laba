package com.solvd.laba.dao;

import com.solvd.laba.pojo.Passenger;

public interface IEntityDAO<T>{
    public void save(T t);
    public void delete(T t);
    public void update(T t);
    Passenger getById(long id);
}

