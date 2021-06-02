package com.app.models;

import java.time.LocalDate;

public class Blog {
    private int id;
    private String description;
    private LocalDate date;
    private Class aClass;

    public Blog(int id, String description, LocalDate date, Class aClass) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.aClass = aClass;
    }

    public Blog() {
    }

    public Blog(String description, LocalDate date, Class aClass) {
        this.description = description;
        this.date = date;
        this.aClass = aClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }
}
