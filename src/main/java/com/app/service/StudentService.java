package com.app.service;

import com.app.config.ConnectionJDBC;
import com.app.models.Address;
import com.app.models.Status;
import com.app.models.Student;
import com.app.service.IService;

import java.sql.Connection;
import java.util.List;

public class StudentService implements IService<Student> {
    Connection connection = ConnectionJDBC.getConnection();

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void save(Student p) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(int id, Student student) {

    }
}
