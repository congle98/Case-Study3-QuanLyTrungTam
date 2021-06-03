package com.app.controller;



import com.app.models.Address;
import com.app.models.Admin;
import com.app.models.Supervisor;
import com.app.service.addressService.AddressService;
import com.app.service.adminService.AdminService;
import com.app.service.classService.ClassService;
import com.app.service.statusService.StatusService;
import com.app.service.supervisorService.SupervisorService;

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
    private static AdminService adminService = new AdminService();
    private static SupervisorService supervisorService = new SupervisorService();
    private static ClassService classService = new ClassService();
    private static AddressService addressService = new AddressService();
    private static StatusService statusService = new StatusService();
    private static Admin adminMain = null;
    private static List<Supervisor> supervisorListMain = supervisorService.findAll();
    private static List<Address> addressListMain  = addressService.findAll();




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "home":
                adminHomePage(req,resp);
                break;
            case "create":
                showFormCreate(req,resp);
                break;
            default:
                adminLoginPage(req,resp);
                break;
        }
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.sendRedirect("admin/userCreate.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "home":
                adminHomePage(req,resp);
                break;
            case "login":
                loginAdmin(req,resp);
                break;
            default:
                adminLoginPage(req,resp);
                break;
        }
    }



    private void adminLoginPage(HttpServletRequest req, HttpServletResponse resp){
        try {
            resp.sendRedirect("/admin/adminLogin.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void adminHomePage(HttpServletRequest req, HttpServletResponse resp) {
       req.setAttribute("admin",adminMain);
       req.setAttribute("supervisorList",supervisorListMain);
       RequestDispatcher rd = req.getRequestDispatcher("/admin/adminHome.jsp");
        try {
            rd.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loginAdmin(HttpServletRequest req, HttpServletResponse resp) {
        List<Admin> adminList = adminService.findAll();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean check = false;
        for (Admin a: adminList
        ) {
            if(a.getEmail().equals(email)&& a.getPassword().equals(password)){
                    check = true;
                    req.setAttribute("admin",a);
                    adminMain = a;
                    adminHomePage(req,resp);
            }
        }
        if(!check){
            adminLoginPage(req,resp);
        }
    }
}
