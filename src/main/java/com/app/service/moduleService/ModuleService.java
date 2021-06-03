package com.app.service.moduleService;

import com.app.config.ConnectionJDBC;
import com.app.model.Class;
import com.app.model.Module;
import com.app.model.Student;
import com.app.service.classService.ClassService;
import com.app.service.classService.IClassService;
import com.app.service.studentService.IStudentService;
import com.app.service.studentService.StudentService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ModuleService implements IModuleService{
    public static final String GET_ALL_MODULE = "select * from module join student_module sm on module.id = sm.module_id;";
    Connection connection = ConnectionJDBC.getConnection();
    IClassService classService = new ClassService();
    IStudentService studentService = new StudentService();

    @Override
    public List<Module> findAll() {
        List<Module> list = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(GET_ALL_MODULE);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int class_id = rs.getInt("class_id");
                Class class1 = classService.findById(class_id);
                LocalDate dateStart = rs.getDate("date_start").toLocalDate();
                LocalDate dateEnd = rs.getDate("date_end").toLocalDate();
                int student_id = rs.getInt("student_id");
                Student student = studentService.findById(student_id);
                List<Student> studentList = new ArrayList<>();
                studentList.add(student);
                Module module = new Module(id,name,class1,dateStart,dateEnd,studentList);
                list.add(module);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Module findById(int id) {
        return null;
    }

    @Override
    public void save(Module p) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(int id, Module module) {

    }
}
