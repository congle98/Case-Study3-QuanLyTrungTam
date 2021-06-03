package com.app.controller;

import com.app.model.Blog;
import com.app.model.Module;
import com.app.service.blogService.BlogService;
import com.app.service.blogService.IBlogService;
import com.app.service.moduleService.IModuleService;
import com.app.service.moduleService.ModuleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/Teacher")
public class TeacherServlet extends HttpServlet {
    IModuleService moduleService = new ModuleService();
    IBlogService blogService = new BlogService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = null;
        if(action == null){
            action = "";
        }
        switch (action){
            default:
//                try {
//                    showListModule(req,resp);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
                try {
                    showAllListBlog(req,resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void showAllListBlog(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Blog> list = blogService.findAll();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/teacher/teacherList.jsp");
        req.setAttribute("listBlog",list);
        dispatcher.forward(req,resp);
    }

//    private void showListModule(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
//        List<Module> list = moduleService.findAll();
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/teacher/teacherList.jsp");
//        req.setAttribute("listModule",list);
//        dispatcher.forward(req,resp);
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
