package com.app.model;

import java.time.LocalDate;

public class Supervisor extends User {
    public Supervisor() {
    }

    public Supervisor(int id, String name, String email, String password, String url, Address address, LocalDate dob, Status status) {
        super(id, name, email, password, url, address, dob, status);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
