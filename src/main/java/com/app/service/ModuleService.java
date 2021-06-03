package com.app.service;

import com.app.config.ConnectionJDBC;
import com.app.models.Module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ModuleService implements IService<Module> {
    private static final String SELECT_ALL_MODULE = "SELECT * FROM module;";
    Connection connection = ConnectionJDBC.getConnection();
    IService classService = new ClassService();

    @Override
    public List<Module> findAll() {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_MODULE);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String aname = resultSet.getString("name");
                int class_id = resultSet.getInt("class_id");
//                Class c = new ClassService(findById(class_id));
//                resultSet.
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
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
