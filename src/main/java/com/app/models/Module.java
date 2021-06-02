package com.app.models;

import java.time.LocalDate;
import java.util.List;

public class Module {
    private int id;
    private String name;
    private Class aClass;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    List<Student> studentList;


    public Module(int id, String name, Class aClass, LocalDate dateStart, LocalDate dateEnd, List<Student> studentList) {
        this.id = id;
        this.name = name;
        this.aClass = aClass;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.studentList = studentList;
    }

    public Module(String name, Class aClass, LocalDate dateStart, LocalDate dateEnd, List<Student> studentList) {
        this.name = name;
        this.aClass = aClass;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.studentList = studentList;
    }

    public Module(int id, String name, Class aClass, LocalDate dateStart, List<Student> studentList) {
        this.id = id;
        this.name = name;
        this.aClass = aClass;
        this.dateStart = dateStart;
        this.studentList = studentList;
    }

    public Module(String name, Class aClass, LocalDate dateStart, List<Student> studentList) {
        this.name = name;
        this.aClass = aClass;
        this.dateStart = dateStart;
        this.studentList = studentList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
