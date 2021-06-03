package com.app.models;

import java.time.LocalDate;

public class Blog {
    private int id;
    private String description;
    private LocalDate date;
    private Class Class;

    public Blog(int id, String description, LocalDate date, Class Class) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.Class = Class;
    }

    public Blog() {
    }

    public Blog(String description, LocalDate date, Class Class) {
        this.description = description;
        this.date = date;
        this.Class = Class;
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
        return Class;
    }

    public void setaClass(Class Class) {
        this.Class = Class;
    }
}
