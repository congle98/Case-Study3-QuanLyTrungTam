package com.app.service;
import com.app.models.Status;

import java.sql.SQLException;
import java.util.List;

public interface IService<T> {
    List<T> findAll() throws SQLException;
    T findById(int id) throws SQLException;
    void save(T p) throws SQLException;

    void delete(int id) throws SQLException;
    void edit(int id, T t) throws SQLException;
}
