package main.java.com.solvd.laba.dao.jdbc;

public interface EntityDAO<T, U> {
    public void save (T t);
    public void delete (T t);
    T getById(U id);
}