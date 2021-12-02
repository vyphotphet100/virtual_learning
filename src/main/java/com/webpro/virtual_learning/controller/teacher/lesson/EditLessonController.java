package com.webpro.virtual_learning.controller.teacher.lesson;

import com.webpro.virtual_learning.entity.LessonEntity;
import com.webpro.virtual_learning.service.ILessonService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/teacher/edit-lesson")
public class EditLessonController extends HttpServlet {

    @Inject
    private ILessonService lessonService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        LessonEntity lessonEntity = lessonService.findById(id);
        if (lessonEntity == null)
            return;

        request.setAttribute("lesson", lessonEntity);

        request.getRequestDispatcher("/teacher/edit-lesson-teacher.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
