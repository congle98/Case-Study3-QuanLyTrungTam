package com.app.controller;



import com.app.models.Admin;
import com.app.service.adminService.AdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
    AdminService adminService = new AdminService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            default:
                adminHomePage(req,resp);
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
            case "login":
                loginAdmin(req,resp);
                break;
            default:
                adminHomePage(req,resp);
                break;
        }
    }



    private void adminHomePage(HttpServletRequest req, HttpServletResponse resp){
        try {
            resp.sendRedirect("/admin/adminLogin.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loginAdmin(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher rd = req.getRequestDispatcher("/admin/adminHome.jsp");
        List<Admin> adminList = adminService.findAll();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Admin admin = new Admin(email,password);



        boolean check = false;
        for (Admin a: adminList
        ) {
            if(a.getEmail().equals(admin.getEmail() )&& a.getPassword().equals(admin.getPassword())){
                try {
                    check = true;
                    resp.sendRedirect("/admin/adminHome.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if(!check){
            try {
                resp.sendRedirect("/Admin");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
