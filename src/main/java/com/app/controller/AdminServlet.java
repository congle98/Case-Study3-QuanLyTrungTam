package com.app.controller;



import com.app.models.*;
import com.app.models.Class;
import com.app.service.*;
//import com.app.service.AddressService;
//import com.app.service.addressService.IAddressService;
//import com.app.service.AdminService;
//import com.app.service.adminService.IAdminService;
//import com.app.service.ClassService;
//import com.app.service.classService.IClassService;
//import com.app.service.CourseService;
//import com.app.service.courseService.ICourseService;
//import com.app.service.statusService.IStatusService;
//import com.app.service.StatusService;
//import com.app.service.supervisorService.ISupervisorService;
//import com.app.service.SupervisorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
    private static AdminService adminService = new AdminService();
    private static SupervisorService supervisorService = new SupervisorService();
    private static CourseService courseService = new CourseService();
    private static ClassService classIService = new ClassService();
    private static AddressService addressService = new AddressService();
    private static StatusService statusService = new StatusService();
    private static Admin adminMain = null;
    private static List<Supervisor> supervisorListMain = supervisorService.findAll();
    private static List<Address> addressListMain  = addressService.findAll();
    private static List<Course> courseListMain = courseService.findAll();
    private static List<Status> statusListMain = statusService.findAll();
    private static List<Class> classListMain = classIService.findAll();




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println(action);
        if(action == null){
            action = "";
        }
        switch (action){
            case "home":
                adminHomePage(req,resp);
                break;
            case "supervisorCreate":
                showFormSupervisorCreate(req,resp);
                break;
            default:
                adminLoginPage(req,resp);
                break;
        }
    }

    private void showFormSupervisorCreate(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("addressList",addressListMain);
        req.setAttribute("statusList",statusListMain);
        RequestDispatcher rd = req.getRequestDispatcher("/admin/supervisorCreate.jsp");
        try {
            rd.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println(action);
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
            case "supervisorCreate":
                createSupervisor(req,resp);
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
    private void createSupervisor(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String url = req.getParameter("url");
        LocalDate dob = LocalDate.parse(req.getParameter("dob"));
        Address address = addressService.findById(Integer.parseInt(req.getParameter("address_id")));
        Status status = statusService.findById(Integer.parseInt(req.getParameter("status_id")));
        supervisorService.save(new Supervisor(name,email,password,url,address,dob,status));
        supervisorListMain = supervisorService.findAll();
        adminHomePage(req,resp);
    }
}
