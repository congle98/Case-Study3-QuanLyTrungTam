package com.app.service.classService;

import com.app.config.ConnectionJDBC;
import com.app.model.Class;
import com.app.model.Course;
import com.app.model.Teacher;
import com.app.service.courseService.CourseService;
import com.app.service.courseService.ICourseService;
import com.app.service.teacherService.ITeacherService;
import com.app.service.teacherService.TeacherService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassService implements IClassService{
    private static final String SELECT_ALL_CLASS = "SELECT * FROM class;";
    private static final String SELECT_CLASS_BY_ID = "SELECT * FROM class WHERE class.id =?;";
    ICourseService courService = new CourseService();
    ITeacherService teacherService = new TeacherService();
    Connection connection = ConnectionJDBC.getConnection();
    @Override
    public List<Class> findAll() {
        List<Class> listClass = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CLASS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int idTeacher = resultSet.getInt("teacher_id");
                int idCourse = resultSet.getInt("course_id");
                Teacher teacher = teacherService.findById(idTeacher);
                Course course = courService.findById(idCourse);
                Class class1 = new Class(id,name,teacher,course); System.out.println("loi cmnr");
                listClass.add(class1);
                for (Class a: listClass
                     ) {
                    System.out.println(a);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listClass;
    }

    @Override
    public Class findById(int id) {
        Class classById = new Class();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CLASS_BY_ID);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                int idTeacher = resultSet.getInt("teacher_id");
                int idCourse = resultSet.getInt("course_id");
                Teacher teacher = teacherService.findById(idTeacher);
                Course course = courService.findById(idCourse);
                classById = new Class(id,name,teacher,course);

            }        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return classById;
    }

    @Override
    public void save(Class p) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(int id, Class aClass) {

    }
}
