package com.app.model;

import java.time.LocalDate;

public class Teacher extends User{
    public Teacher() {
    }

    public Teacher(int id, String name, String email, String password, String url, Address address, LocalDate dob, Status status) {
        super(id, name, email, password, url, address, dob, status);
    }

    public Teacher(String email, String password) {
        super(email, password);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public String getUrl() {
        return super.getUrl();
    }

    @Override
    public void setUrl(String url) {
        super.setUrl(url);
    }

    @Override
    public Address getAddress() {
        return super.getAddress();
    }

    @Override
    public void setAddress(Address address) {
        super.setAddress(address);
    }

    @Override
    public LocalDate getDob() {
        return super.getDob();
    }

    @Override
    public void setDob(LocalDate dob) {
        super.setDob(dob);
    }

    @Override
    public Status getStatus() {
        return super.getStatus();
    }

    @Override
    public void setStatus(Status status) {
        super.setStatus(status);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
