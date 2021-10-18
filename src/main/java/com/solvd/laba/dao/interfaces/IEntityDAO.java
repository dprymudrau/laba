package com.solvd.laba.dao.interfaces;

import java.util.ArrayList;

public interface IEntityDAO<T, Z> {
    void printAll();
    ArrayList<T> getAll();
    T getById(Z id);
    void insertToTable(T entity);
    void updateEntityRow(T entity);
    void deleteById(Z id);
}
