package com.webpro.virtual_learning.controller;

import com.webpro.virtual_learning.dao.IRoleDAO;
import com.webpro.virtual_learning.dao.impl.RoleDAO;
import com.webpro.virtual_learning.dao.impl.UserDAO;
import com.webpro.virtual_learning.dto.RoleDTO;
import com.webpro.virtual_learning.dto.UserDTO;

import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.sql.Date;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "test", value = "/test")
public class HelloServlet extends HttpServlet {
    private String message;

    //@Inject
    private UserDAO userDao = new UserDAO();

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
        UserDTO userDto = new UserDTO();
        userDto.setUsername("user3");
        userDto.setPassword("123456");
        userDto.setFullName("Test");
        Date date = Date.valueOf(LocalDate.of(2001, 12, 22));
        userDto.setBirthday(date);
        userDto.setRoleCode("STUDENT");
        userDao.save(userDto);
    }

    public void destroy() {
    }
}