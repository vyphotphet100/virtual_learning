package com.webpro.virtual_learning.controller.teacher.lesson;

import com.google.gson.Gson;
import com.webpro.virtual_learning.converter.dto_entity.DTOEntityConverter;
import com.webpro.virtual_learning.converter.httprequest_dto.HttpRequestDTOConverter;
import com.webpro.virtual_learning.converter.httprequest_dto.mapper.LessonHttpRequestDTOMapper;
import com.webpro.virtual_learning.dto.LessonDTO;
import com.webpro.virtual_learning.entity.LessonEntity;
import com.webpro.virtual_learning.entity.QuestionEntity;
import com.webpro.virtual_learning.service.ILessonService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/teacher/add-lesson"})
public class AddLessonController extends HttpServlet {

    @Inject
    private ILessonService lessonService;

    @Inject
    private HttpRequestDTOConverter requestDTOConverter;

    @Inject
    private LessonHttpRequestDTOMapper lessonHttpRequestDTOMapper;

    @Inject
    private DTOEntityConverter dtoEntityConverter;

    private Gson gson = new Gson();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/teacher/add-lesson-teacher.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // fake data
        LessonDTO lessonDto = new LessonDTO();
        lessonDto.setTitle("Test class");
        lessonDto.setDescription("Description");
        lessonDto.setVideo("https://www.youtube.com/watch?v=Uc59ulnJI2o");
        lessonDto.setClassId(3L);

        //LessonDTO lessonDto = requestDTOConverter.toDTO(request, lessonHttpRequestDTOMapper);
        LessonEntity lessonEntity = lessonService.save(lessonDto);
        lessonDto = (LessonDTO) dtoEntityConverter.toDTO(lessonEntity, LessonDTO.class);
        String lessonDtoJson = this.gson.toJson(lessonDto);
        response.getWriter().write(lessonDtoJson);
    }
}
