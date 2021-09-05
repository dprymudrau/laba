package com.solvd.laba.dao.interfaces.generics;

public interface IEntityDAO <T> {
    public void save (T t);
    public void delete (T t);

}
