package com.controller;

import com.util.DatabaseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateteacher")
public class UpdateteacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int tid =Integer.parseInt(req.getParameter("tid"));
        req.setAttribute("teacher",DatabaseUtils.getTeacher(tid));
        req.setAttribute("courses", DatabaseUtils.listCourses());
        req.setAttribute("titles", DatabaseUtils.listTitles());
        req.getRequestDispatcher("/WEB-INF/jsp/updateteacher.jsp").forward(req, resp);
    }
}
