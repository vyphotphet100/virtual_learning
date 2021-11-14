package com.webpro.virtual_learning.controller.teacher.lesson;

import com.webpro.virtual_learning.entity.ClassEntity;
import com.webpro.virtual_learning.entity.LessonEntity;
import com.webpro.virtual_learning.service.IClassService;
import com.webpro.virtual_learning.service.ILessonService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/teacher/lesson"})
public class LessonController extends HttpServlet {

    @Inject
    private ILessonService lessonService;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LessonEntity lessonEntity = null;
        try {
            lessonEntity = lessonService.findById(Long.parseLong(request.getParameter("id")));
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }

        request.setAttribute("lesson", lessonEntity);
        request.setAttribute("clazz", lessonEntity.getClazz());
        request.getRequestDispatcher("/teacher/lesson-teacher.jsp").forward(request, response);
    }
}
