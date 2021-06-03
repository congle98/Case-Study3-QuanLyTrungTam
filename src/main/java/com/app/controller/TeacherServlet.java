package com.app.controller;

import com.app.model.Blog;
import com.app.model.Module;
import com.app.model.Teacher;
import com.app.service.blogService.BlogService;
import com.app.service.blogService.IBlogService;
import com.app.service.moduleService.IModuleService;
import com.app.service.moduleService.ModuleService;
import com.app.service.teacherService.ITeacherService;
import com.app.service.teacherService.TeacherService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/Teacher")
public class TeacherServlet extends HttpServlet {
    IModuleService moduleService = new ModuleService();
    IBlogService blogService = new BlogService();
    ITeacherService teacherService = new TeacherService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = null;
        if(action == null){
            action = "";
        }
        try {
        switch (action){
            case "edit":
                showFormEdit(req,resp);
                break;
            default:
//              showListModule(req,resp);
                showAllListTeacher(req,resp);
//                showAllListBlog(req,resp);
                break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/teacher/teacherEdit.jsp");
//        List<Teacher> teacherList = new ArrayList<>();
        int id = Integer.parseInt(req.getParameter("id"));
        Teacher teacher = teacherService.findById(id);
        req.setAttribute("teacher",teacher);
//        req.setAttribute("teacherList",teacherList);
        dispatcher.forward(req,resp);
    }

    private void showAllListTeacher(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Teacher> teacherList = teacherService.findAll();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/teacher/teacherList.jsp");
        req.setAttribute("teacherList",teacherList);
        dispatcher.forward(req,resp);
    }

//    private void showAllListBlog(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
//        List<Blog> list = blogService.findAll();
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/teacher/teacherList.jsp");
//        req.setAttribute("listBlog",list);
//        dispatcher.forward(req,resp);
//    }

//    private void showListModule(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
//        List<Module> list = moduleService.findAll();
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/teacher/teacherList.jsp");
//        req.setAttribute("listModule",list);
//        dispatcher.forward(req,resp);
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "edit":
                editTeacher(req,resp);
                break;
        }
    }

    private void editTeacher(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String url = req.getParameter("url");
    }
}
