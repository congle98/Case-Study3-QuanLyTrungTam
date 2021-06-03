package com.app.service.supervisorService;

import com.app.config.ConnectionJDBC;
import com.app.model.Address;
import com.app.model.Status;
import com.app.model.Supervisor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SupervisorService implements  ISupervisorService{
    Connection connection = ConnectionJDBC.getConnection();

    private String FIND_ALL_SUPERVISOR = "select\n" +
            "    s.id as supervisor_id,\n" +
            "       s.name as supervisor_name,\n" +
            "       s.dob as supervisor_dob,\n" +
            "       s.email as supervisor_email,\n" +
            "       s.password as supervisor_password,\n" +
            "       s.url_img as supervisor_img,\n" +
            "       a.id as address_id,\n" +
            "       a.name as address_name,\n" +
            "       s2.id as status_id,\n" +
            "       s2.name as status_name\n" +
            "from supervisor as s join address a on a.id = s.address_id\n" +
            "join status s2 on s2.id = s.status_id;";
    @Override
    public List<Supervisor> findAll() {
        List<Supervisor> supervisorList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(FIND_ALL_SUPERVISOR);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int address_id = resultSet.getInt("address_id");
                String address_name = resultSet.getString("address_name");
                Address address = new Address(address_id,address_name);
                int status_id = resultSet.getInt("status_id");
                String status_name = resultSet.getString("status_name");
                Status status = new Status(status_id,status_name);
                int supervisor_id = resultSet.getInt("supervisor_id");
                String supervisor_name = resultSet.getString("supervisor_name");
                String supervisor_email = resultSet.getString("supervisor_email");
                String supervisor_password = resultSet.getString("supervisor_password");
                String supervisor_img = resultSet.getString("supervisor_img");
                LocalDate supervisor_dob = resultSet.getDate("supervisor_dob").toLocalDate();
                Supervisor supervisor = new Supervisor();
                supervisor.setId(supervisor_id);
                supervisor.setDob(supervisor_dob);
                supervisor.setEmail(supervisor_email);
                supervisor.setName(supervisor_name);
                supervisor.setPassword(supervisor_password);
                supervisor.setUrl(supervisor_img);
                supervisor.setStatus(status);
                supervisor.setAddress(address);
                supervisorList.add(supervisor);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return supervisorList;
    }

    @Override
    public Supervisor findById(int id) {
        return null;
    }

    @Override
    public void save(Supervisor p) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(int id, Supervisor supervisor) {

    }
}
