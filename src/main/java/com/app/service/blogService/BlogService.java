package com.app.service.blogService;

import com.app.config.ConnectionJDBC;
import com.app.model.Blog;
import com.app.model.Class;
import com.app.service.classService.ClassService;
import com.app.service.classService.IClassService;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BlogService implements IBlogService{
    public static final String GET_ALL_BLOG = "select * from blog;";
    public static final String GET_ALL_BLOG_BY_ID = "select * from blog where id = ?;";
    public static final String CREATE_BLOG = "insert into blog(description, date, class_id) VALUES (?,?,?);";
    public static final String DELETE_FROM_BLOG_WHERE_ID = "delete from blog where id = ?;";
    public static final String UPDATE_BLOG_BY_ID = "update blog set description = ?, date = ?, class_id = ? where id = ?;";
    Connection connection = ConnectionJDBC.getConnection();
    IClassService classService = new ClassService();

    @Override
    public List<Blog> findAll() {
        List<Blog> blogs = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_BLOG);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String description = rs.getString("description");
                LocalDate date = rs.getDate("date").toLocalDate();
                int class_id = rs.getInt("class_id");
                Class class1 = classService.findById(class_id);
                Blog blog = new Blog(id,description,date,class1);
                blogs.add(blog);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return blogs;
    }

    @Override
    public Blog findById(int id) {
        Blog blog = null;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_BLOG_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                int blog_id = rs.getInt("id");
                String description = rs.getString("description");
                LocalDate date = rs.getDate("date").toLocalDate();
                int class_id = rs.getInt("class_id");
                Class class1 = classService.findById(class_id);
                blog = new Blog(blog_id,description,date,class1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return blog;
    }

    @Override
    public void save(Blog p) {
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE_BLOG);
            statement.setString(1,p.getDescription());
            statement.setDate(2, Date.valueOf(p.getDate()));
            statement.setInt(3,p.getaClass().getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_FROM_BLOG_WHERE_ID);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void edit(int id, Blog blog) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_BLOG_BY_ID);
            statement.setString(1,blog.getDescription());
            statement.setDate(2, Date.valueOf(blog.getDate()));
            statement.setInt(3,blog.getaClass().getId());
            statement.setInt(4,id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
