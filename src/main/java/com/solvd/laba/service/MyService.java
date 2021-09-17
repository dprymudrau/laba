package com.solvd.laba.service;

public interface MyService<T, U> {
    void doSmth();
    T getById(U id);
    T setById(U id);
    T checkDb(U id);
}
