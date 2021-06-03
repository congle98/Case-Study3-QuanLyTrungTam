package com.app.models;

import java.time.LocalDate;
import java.util.List;

public class Student extends User{
    private Class class_;
    private List<Module> moduleList;

    public Student(int id, String name, String email, String password, String url, Address address, LocalDate dob, Status status, Class class_, List<Module> moduleList) {
        super(id, name, email, password, url, address, dob, status);
        this.class_ = class_;
        this.moduleList = moduleList;
    }

    public Class getClass_() {
        return class_;
    }

    public void setClass_(Class class_) {
        class_ = class_;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }


    public Student(int id, String name, String email, String password, String url, Address address, LocalDate dob, Status status, Class class_) {
        super(id, name, email, password, url, address, dob, status);
        this.class_ = class_;
    }
    public Student(String name, String email, String password, String url, Address address, LocalDate dob, Status status, Class class_) {
        super(name, email, password, url, address, dob, status);
        this.class_ = class_;
    }

}
