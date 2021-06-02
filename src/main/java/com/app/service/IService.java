package com.app.service;
import java.sql.SQLException;
import java.util.List;

public interface IService<T> {
    List<T> findAll() throws SQLException;
    T findById(int id) throws SQLException;
    void save(T p);
    void delete(int id);
    void edit(int id, T t);
}
