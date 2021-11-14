package com.webpro.virtual_learning.controller.teacher;

import com.webpro.virtual_learning.converter.httprequest_dto.HttpRequestDTOConverter;
import com.webpro.virtual_learning.converter.httprequest_dto.mapper.ClassHttpRequestDTOMapper;
import com.webpro.virtual_learning.dto.ClassDTO;
import com.webpro.virtual_learning.entity.ClassEntity;
import com.webpro.virtual_learning.service.IClassService;
import com.webpro.virtual_learning.service.ISubjectService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/teacher/edit-class"})
public class EditClassController extends HttpServlet {
    @Inject
    private IClassService classService;

    @Inject
    private ISubjectService subjectService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long classId = null;
        try {
            classId = Long.parseLong(request.getParameter("id"));
        } catch(Exception ex) {
            ex.printStackTrace();
            return;
        }
        ClassEntity classEntity = classService.findById(classId);
        if (classEntity == null)
            return;

        request.setAttribute("clazz", classEntity);
        request.setAttribute("subjects", subjectService.findAll());
        request.getRequestDispatcher("/teacher/edit-class-teacher.jsp").forward(request, response);
    }

    @Inject
    private HttpRequestDTOConverter requestDTOConverter;

    @Inject
    private ClassHttpRequestDTOMapper classMapper;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ClassDTO classDto = requestDTOConverter.toDTO(request, classMapper);
        ClassEntity classEntity = classService.update(classDto);
        request.setAttribute("responseEntity", classEntity);
        this.doGet(request, response);
        //response.sendRedirect("/teacher/edit-class?id=" + classEntity.getId());
    }
}
