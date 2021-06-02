package com.app.service.statusService;

import com.app.config.ConnectionJDBC;
import com.app.models.Status;
import com.app.service.IService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusService implements IStatusService {
    public static final String SELECT_ALL_STT =
            "SELECT * FROM status;";

    public static final String SELECT_STT_BY_ID =
            "SELECT * FROM  status where status.id =?;";

    public static final String SAVE_STT =
            "INSERT INTO status ( name) VALUE(?);";

    public static final String DELETE_STT_BY_ID =
            "DELETE FROM status where status.id =?;";

    public static final String UPDATE_STT =
            "UPDATE status SET name =? WHERE status.id=?;";

    Connection connection = ConnectionJDBC.getConnection();

    @Override
    public List<Status> findAll() throws SQLException {
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
    public Status findById(int id) throws SQLException {
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
    public void save(Status status) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SAVE_STT);
        statement.setString(1, status.getName());
        statement.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement statement =  connection.prepareStatement(DELETE_STT_BY_ID);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    @Override
    public void edit(int id, Status status) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE_STT);
        statement.setString(1, status.getName());
        statement.setInt(2,id);
        statement.executeUpdate();
    }
}
