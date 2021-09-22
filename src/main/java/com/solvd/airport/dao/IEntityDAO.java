package com.solvd.airport.dao;

public interface IEntityDAO<T> {

    void save(T t);

    void delete(T t);

    T getById(long id);

}
