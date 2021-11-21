package com.webpro.virtual_learning.controller.student.lesson;

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

@WebServlet(urlPatterns = {"/student/lesson"})
public class LessonController extends HttpServlet {

    @Inject
    private ILessonService lessonService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long lessonId = Long.parseLong(request.getParameter("id"));
        if (lessonId == null)
            return;

        LessonEntity lessonEntity = lessonService.findById(lessonId);
        request.setAttribute("lesson", lessonEntity);
        request.setAttribute("clazz", lessonEntity.getClazz());

        request.getRequestDispatcher("/student/lesson-student.jsp").forward(request, response);
    }
}
