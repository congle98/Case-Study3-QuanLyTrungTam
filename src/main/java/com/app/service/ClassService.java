
        package com.app.service;
        import com.app.config.ConnectionJDBC;
        import com.app.models.Class;
        import com.app.models.Course;
        import com.app.models.Teacher;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

public class ClassService implements IService<Class>{
    private static final String SELECT_ALL_CLASS = "SELECT * FROM class;";
    private static final String SELECT_CLASS_BY_ID = "SELECT * FROM class WHERE class.id =?;";
    private static final String INSERT_CLASS = "INSERT INTO class (name, teacher_id , course_id) VALUE (?,?,?);";
    private static final String DELETE_CLASS_BY_ID = "DELETE FROM class WHERE class.id =?;";
    private static final String UPDATE_CLASS_BY_ID = "UPDATE class SET name =?, teacher_id =?, course_id =? WHERE class.id=?;";
    IService<Course> courService = new CourseService();
    IService<Teacher> teacherService = new TeacherService();
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
//                int idTeacher = resultSet.getInt("teacher_id");
                int idCourse = resultSet.getInt("course_id");
//                Teacher teacher = teacherService.findById(idTeacher);
                Course course = courService.findById(idCourse);
                Class class1 = new Class(id,name,course); System.out.println("loi cmnr");
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
                classById = new Class(id,name,course);

            }        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return classById;
    }

    @Override
    public void save(Class p) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_CLASS);
            statement.setString(1, p.getName());
            statement.setInt(2, p.getTeacher().getId());
            statement.setInt(3, p.getCourse().getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_CLASS_BY_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void edit(int id, Class Class) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_CLASS_BY_ID);
            statement.setString(1, Class.getName());
            statement.setInt(2, Class.getTeacher().getId());
            statement.setInt(3, Class.getCourse().getId());
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
