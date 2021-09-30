package main.java.com.solvd.laba.dao.service.impl;

public interface MyService<T, U> {
    void doSmth();
    T getById(U id);
    T setById(U id);
    T checkDb(U id);
}

