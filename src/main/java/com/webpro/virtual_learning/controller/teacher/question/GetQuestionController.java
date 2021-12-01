package com.webpro.virtual_learning.controller.teacher.question;

import com.google.gson.Gson;
import com.webpro.virtual_learning.converter.dto_entity.DTOEntityConverter;
import com.webpro.virtual_learning.dto.QuestionDTO;
import com.webpro.virtual_learning.entity.QuestionEntity;
import com.webpro.virtual_learning.service.IQuestionService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/teacher/get-question"})
public class GetQuestionController extends HttpServlet {
    private Gson gson = new Gson();

    @Inject
    private IQuestionService questionService;

    @Inject
    private DTOEntityConverter dtoEntityConverter;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        QuestionEntity questionEntity = questionService.findById(id);
        QuestionDTO questionDto = (QuestionDTO)dtoEntityConverter.toDTO(questionEntity, QuestionDTO.class);
        String questionDtoJson = this.gson.toJson(questionDto);
        response.getWriter().write(questionDtoJson);
    }
}
