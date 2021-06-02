package com.app.controller;

import com.app.models.Status;
import com.app.service.IService;
import com.app.service.statusService.StatusService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    IService statusService = new StatusService();
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
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/studentList.jsp");
        List<Status> listSTT = statusService.findAll();
        req.setAttribute("listSTT", listSTT);
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
