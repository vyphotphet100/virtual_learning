package com.webpro.virtual_learning.controller;

import com.webpro.virtual_learning.dao.IRoleDAO;
import com.webpro.virtual_learning.dao.impl.RoleDAO;
import com.webpro.virtual_learning.dto.RoleDTO;

import java.io.*;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "test", value = "/test")
public class HelloServlet extends HttpServlet {
    private String message;

    //@Inject
    private RoleDAO roleDao = new RoleDAO();

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
        response.setContentType("text/html");
        roleDao.delete(3L);

    }

    public void destroy() {
    }
}