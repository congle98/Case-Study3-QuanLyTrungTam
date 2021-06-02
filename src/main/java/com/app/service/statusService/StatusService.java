package com.app.service.statusService;

import com.app.config.ConnectionJDBC;
import com.app.models.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusService implements IStatusService{
    public static final String SELECT_ALL_STT = "SELECT * FROM status;";
    public static final String SELECT_STT_BY_ID = "SELECT * FROM  status where status.id =?;";
    Connection connection = ConnectionJDBC.getConnection();
    @Override
    public List findAll() throws SQLException {
        List <Status> listStatus = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STT);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            listStatus.add(new Status(id,name));
            for (Status s: listStatus
                 ) {
                System.out.println(s);
            }
        }
        return listStatus;
    }

    @Override
    public Object findById(int id) throws SQLException {
        Status status = null;
        PreparedStatement statement = connection.prepareStatement(SELECT_STT_BY_ID);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            status = new Status(id,name);
        }
        return status;
    }

    @Override
    public void save(Object p) {
//        Status status;
//        PreparedStatement statement = connection.prepareStatement()
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(int id, Object o) {

    }
}
