package com.webpro.virtual_learning.controller.teacher.lesson;

import com.google.gson.Gson;
import com.webpro.virtual_learning.converter.dto_entity.DTOEntityConverter;
import com.webpro.virtual_learning.converter.httprequest_dto.HttpRequestDTOConverter;
import com.webpro.virtual_learning.converter.httprequest_dto.mapper.ClassHttpRequestDTOMapper;
import com.webpro.virtual_learning.converter.httprequest_dto.mapper.LessonHttpRequestDTOMapper;
import com.webpro.virtual_learning.dto.LessonDTO;
import com.webpro.virtual_learning.entity.LessonEntity;
import com.webpro.virtual_learning.service.ILessonService;
import com.webpro.virtual_learning.utils.MyUtil;

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

    @Inject
    private HttpRequestDTOConverter requestDTOConverter;

    @Inject
    private LessonHttpRequestDTOMapper lessonHttpRequestDTOMapper;

    @Inject
    private DTOEntityConverter dtoEntityConverter;

    private Gson gson = new Gson();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        LessonEntity lessonEntity = lessonService.findById(id);
        if (lessonEntity == null)
            return;

        lessonEntity.setQuestions(MyUtil.sortQuestionEntities(lessonEntity.getQuestions()));
        request.setAttribute("lesson", lessonEntity);

        request.getRequestDispatcher("/teacher/edit-lesson-teacher.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LessonDTO lessonDto = requestDTOConverter.toDTO(request, lessonHttpRequestDTOMapper);
        LessonEntity lessonEntity = lessonService.update(lessonDto);
        lessonDto = (LessonDTO) dtoEntityConverter.toDTO(lessonEntity, LessonDTO.class);
        String lessonDtoJson = this.gson.toJson(lessonDto);
        response.getWriter().write(lessonDtoJson);
    }
}
