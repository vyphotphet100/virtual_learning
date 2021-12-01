package com.webpro.virtual_learning.controller.teacher.question;

import com.webpro.virtual_learning.service.IQuestionService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/teacher/delete-question"})
public class DeleteQuestionController extends HttpServlet {

    @Inject
    private IQuestionService questionService;

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            questionService.delete(id);
            response.getWriter().write("true");
        }
        catch (Exception ex) {
            response.getWriter().write("false");
        }

    }
}
