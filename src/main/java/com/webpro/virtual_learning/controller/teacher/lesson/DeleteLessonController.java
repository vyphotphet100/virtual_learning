package com.webpro.virtual_learning.controller.teacher.lesson;

import com.webpro.virtual_learning.dao.ILessonDAO;
import com.webpro.virtual_learning.dao.IQuestionDAO;
import com.webpro.virtual_learning.dao.IUserDAO;
import com.webpro.virtual_learning.entity.ClassEntity;
import com.webpro.virtual_learning.entity.LessonEntity;
import com.webpro.virtual_learning.entity.QuestionEntity;
import com.webpro.virtual_learning.entity.UserEntity;
import com.webpro.virtual_learning.service.IClassService;
import com.webpro.virtual_learning.service.ILessonService;
import com.webpro.virtual_learning.service.IQuestionService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/teacher/delete-lesson"})
public class DeleteLessonController extends HttpServlet {

    @Inject
    private ILessonService lessonService;

    @Inject
    private IClassService classService;

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LessonEntity lessonEntity = null;
        try {
            lessonEntity = lessonService.findById(Long.parseLong(request.getParameter("id")));
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }

        if (lessonEntity == null)
            return;

        lessonService.delete(lessonEntity.getId());
    }
}
