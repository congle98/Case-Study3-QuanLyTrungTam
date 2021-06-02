package com.app.service.studentService;

import com.app.config.ConnectionJDBC;
import com.app.models.Student;

import java.sql.Connection;
import java.util.List;

public class StudentService implements IStudentService{
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
