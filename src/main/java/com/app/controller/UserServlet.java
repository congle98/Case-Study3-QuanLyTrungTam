package com.app.controller;

import com.app.service.adminService.AdminService;
import com.app.service.adminService.IAdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/trang-chu")
public class UserServlet extends HttpServlet {
    IAdminService adminService = new AdminService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "student":
                break;
            case "supervisor":
                break;
            case "teacher":
                break;
            default:
                comeBackIndex(req,resp);
                break;

        }
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){

            case "student":
                break;
            case "supervisor":
                break;
            case "teacher":
                break;
            default:
                comeBackIndex(req,resp);
                break;

        }
    }

    private void comeBackIndex(HttpServletRequest req, HttpServletResponse resp){
        try {
            resp.sendRedirect("/index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
