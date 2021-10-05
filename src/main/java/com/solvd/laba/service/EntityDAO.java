package com.solvd.laba.service;

import java.util.ArrayList;

public interface EntityDAO<T, Z> {
    void printAll();
    void printByFilter(String condition);
    ArrayList<T> getAll();
    ArrayList<T> getAllWithFilter(String condition);
    T getById(Z id);
    void insertToTable(T entity);
    void updateEntityRow(T entity);
    void deleteById(Z id);
    void deleteAllByFilter(String condition);
}
