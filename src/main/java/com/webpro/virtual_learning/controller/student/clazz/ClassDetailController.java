package com.webpro.virtual_learning.controller.student.clazz;

import com.webpro.virtual_learning.entity.ClassEntity;
import com.webpro.virtual_learning.service.IClassService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/student/class-detail"})
public class ClassDetailController extends HttpServlet {
    @Inject
    private IClassService classService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long classId = Long.parseLong(request.getParameter("id"));
        if (classId == null)
            return;

        ClassEntity classEntity = classService.findById(classId);
        request.setAttribute("clazz", classEntity);

        request.getRequestDispatcher("/student/class-detail-student.jsp").forward(request, response);
    }
}
