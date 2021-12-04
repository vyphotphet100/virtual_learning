package com.webpro.virtual_learning.controller.teacher.question;

import com.google.gson.Gson;
import com.webpro.virtual_learning.converter.dto_entity.DTOEntityConverter;
import com.webpro.virtual_learning.converter.httprequest_dto.HttpRequestDTOConverter;
import com.webpro.virtual_learning.converter.httprequest_dto.mapper.QuestionHttpRequestDTOMapper;
import com.webpro.virtual_learning.dto.QuestionDTO;
import com.webpro.virtual_learning.entity.QuestionEntity;
import com.webpro.virtual_learning.service.IQuestionService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/teacher/add-question"})
public class AddQuestionController extends HttpServlet {
    @Inject
    private HttpRequestDTOConverter requestDTOConverter;

    @Inject
    private QuestionHttpRequestDTOMapper questionHttpRequestDTOMapper;

    @Inject
    private IQuestionService questionService;

    @Inject
    private DTOEntityConverter dtoEntityConverter;

    private Gson gson = new Gson();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // fake data
//        QuestionDTO questionDto = new QuestionDTO();
//        questionDto.setContent("Test question content");
//        questionDto.setOption("option1|option2|option3|option4");
//        questionDto.setCorrect(2);
//        questionDto.setLessonId(1L);

        QuestionDTO questionDto = requestDTOConverter.toDTO(request, questionHttpRequestDTOMapper);
        QuestionEntity questionEntity = questionService.save(questionDto);
        questionDto = (QuestionDTO)dtoEntityConverter.toDTO(questionEntity, QuestionDTO.class);
        String questionDtoJson = this.gson.toJson(questionDto);
        response.getWriter().write(questionDtoJson);
    }

}
