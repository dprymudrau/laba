package com.solvd.laba.service;

public interface ProjectServise<T, U> {
    T getProject(U id);
    T setProject(U id);
}
