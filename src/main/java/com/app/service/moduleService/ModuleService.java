package com.app.service.moduleService;

import com.app.config.ConnectionJDBC;
import com.app.models.Module;

import java.sql.Connection;
import java.util.List;

public class ModuleService implements IModuleService{
    Connection connection = ConnectionJDBC.getConnection();

    @Override
    public List<Module> findAll() {
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
