package com.app.service;

import com.app.config.ConnectionJDBC;
import com.app.models.*;
import com.app.models.Class;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IService<Student> {
    private static final String SELECT_ALL_STUDENT = "SELECT * FROM student;";
    private static final String SELECT_MODULE_BY_STUDENT_ID_1 = "select module_id from student_module where student_id=?;";
    private static final String SELECT_FROM_STUDENT_WHERE_STUDENT_ID = "SELECT * FROM student WHERE student.id=?;";
    private static final String INSERT_STUDENT = "INSERT INTO student(name, email, password, address_id, class_id, dob, url_img, status_id ) VALUE (?,?,?,?,?,?,?,?);\n;";
    private static final String DELETE_STUDENT = "CALL delete_student(?);";
    private static final String UPDATE_STUDENT_BY_ID = "UPDATE student SET name=?, email=?, password=?, address_id=?, class_id=?, dob=?, url_img=?, status_id=? WHERE student.id =?;";
    Connection connection = ConnectionJDBC.getConnection();
    IService<Address> addressService = new AddressService();
    IService<Class> classService = new ClassService();
    IService<Status> statusService = new StatusService();
    IService<Module> moduleServices = new ModuleService();

    @Override
    public List<Student> findAll() {
        List<Student>  listStudent= new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STUDENT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String pass = resultSet.getString("password");
                Address address = addressService.findById(resultSet.getInt("address_id"));
                Class cl = classService.findById(resultSet.getInt("class_id"));
                LocalDate dob = resultSet.getDate("dob").toLocalDate();
                String img = resultSet.getString("url_img");
                Status status = statusService.findById(resultSet.getInt("status_id"));
//                List<Module> listMD = findMoudle(1);
//               listStudent.add(new Student(id, name, email, pass, address, cl, dob, img, status, listMD));
               listStudent.add(new Student(id, name, email, pass,img,  address, dob, status, cl));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listStudent;
    }

    public List<Module> findMoudle(int id){
        List<Module> listMD = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_MODULE_BY_STUDENT_ID_1);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Module module = moduleServices.findById(resultSet.getInt("module_id"));
                listMD.add(module);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (Module a: listMD
             ) {
            System.out.println(a);
        }
        return listMD ;
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_STUDENT_WHERE_STUDENT_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id_ = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String pass = resultSet.getString("password");
                Address address = addressService.findById(resultSet.getInt("address_id"));
                Class cl = classService.findById(resultSet.getInt("class_id"));
                LocalDate dob = resultSet.getDate("dob").toLocalDate();
                String img = resultSet.getString("url_img");
                Status status = statusService.findById(resultSet.getInt("status_id"));
//                List<Module> listMD = findMoudle(1);
//               listStudent.add(new Student(id, name, email, pass, address, cl, dob, img, status, listMD));
                student = new Student(id, name, email, pass,img,  address, dob, status, cl);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    @Override
    public void save(Student p) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_STUDENT);
            statement.setString(1, p.getName());
            statement.setString(2, p.getEmail());
            statement.setString(3, p.getPassword());
            statement.setInt(4, p.getAddress().getId());
            statement.setInt(5, p.getClass_().getId());
            statement.setDate(6, Date.valueOf(p.getDob()));
            statement.setString(7, p.getUrl());
            statement.setInt(8, p.getStatus().getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void edit(int id, Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT_BY_ID);
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getPassword());
            statement.setInt(4, student.getAddress().getId());
            statement.setInt(5, student.getClass_().getId());
            statement.setDate(6, Date.valueOf(student.getDob()));
            statement.setString(7, student.getUrl());
            statement.setInt(8, student.getStatus().getId());
            statement.setInt(9, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
