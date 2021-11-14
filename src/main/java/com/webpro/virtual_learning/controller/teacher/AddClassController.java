package com.webpro.virtual_learning.controller.teacher;

import com.webpro.virtual_learning.converter.httprequest_dto.HttpRequestDTOConverter;
import com.webpro.virtual_learning.converter.httprequest_dto.mapper.ClassHttpRequestDTOMapper;
import com.webpro.virtual_learning.dto.ClassDTO;
import com.webpro.virtual_learning.entity.ClassEntity;
import com.webpro.virtual_learning.entity.SubjectEntity;
import com.webpro.virtual_learning.service.IClassService;
import com.webpro.virtual_learning.service.ISubjectService;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"/teacher/add-class"})
public class AddClassController extends HttpServlet {
    @Inject
    private ISubjectService subjectService;

    @Inject
    private HttpRequestDTOConverter requestDTOConverter;

    @Inject
    private ClassHttpRequestDTOMapper classMapper;

    @Inject
    private IClassService classService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<SubjectEntity> subjects = subjectService.findAll();
        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher("/teacher/add-class-teacher.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassDTO classDto = requestDTOConverter.toDTO(request, classMapper);
        ClassEntity responseEntity = null;
        if (!classDto.getPassword().equals(request.getParameter("confirmPassword"))) {
            responseEntity = classService.exceptionObject(new ClassEntity(), "Invalid confirm password");
            request.setAttribute("responseEntity", responseEntity);
            this.doGet(request, response);
            return;
        }

        responseEntity = classService.save(classDto);
        request.setAttribute("responseEntity", responseEntity);
        this.doGet(request, response);
    }
}
