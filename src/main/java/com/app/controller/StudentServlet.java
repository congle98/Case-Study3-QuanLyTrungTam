package com.app.controller;

import com.app.models.Address;
import com.app.models.Class;
import com.app.models.Status;
import com.app.models.Student;
import com.app.service.ClassService;
import com.app.service.IService;
import com.app.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;


@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
   IService<Student> serviceStudent = new StudentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            if(action == null) action = "";
            switch (action){
            default:
                    showAllStataus(req,resp);
                break;
            }
        } catch (SQLException throwables) {
                throwables.printStackTrace();
        }
    }

    private void showAllStataus(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("check.jsp");
        serviceStudent.delete(3);
        req.setAttribute("listSTT", serviceStudent.findAll());
        dispatcher.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
