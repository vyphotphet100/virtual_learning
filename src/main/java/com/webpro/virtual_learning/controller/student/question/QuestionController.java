package com.webpro.virtual_learning.controller.student.question;

import com.webpro.virtual_learning.entity.LessonEntity;
import com.webpro.virtual_learning.service.ILessonService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/student/question"})
public class QuestionController extends HttpServlet {

    @Inject
    private ILessonService lessonService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long lessonId = Long.parseLong(request.getParameter("lessonId"));
        if (lessonId == null)
            return;

        LessonEntity lessonEntity = lessonService.findById(lessonId);
        request.setAttribute("lesson", lessonEntity);

        request.getRequestDispatcher("/student/question-student.jsp").forward(request, response);
    }
}
