package com.webpro.virtual_learning.controller;

import com.webpro.virtual_learning.dao.IRoleDAO;
import com.webpro.virtual_learning.dao.impl.*;
import com.webpro.virtual_learning.dto.*;

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
    private LessonDAO lessonDao = new LessonDAO();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        lessonDao.delete(5L);
        lessonDao.delete(6L);

    }

    public void destroy() {
    }
}