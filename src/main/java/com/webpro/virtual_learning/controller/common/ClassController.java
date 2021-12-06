package com.webpro.virtual_learning.controller.common;

import com.google.gson.Gson;
import com.webpro.virtual_learning.converter.dto_entity.DTOEntityConverter;
import com.webpro.virtual_learning.dto.ClassDTO;
import com.webpro.virtual_learning.entity.ClassEntity;
import com.webpro.virtual_learning.service.IClassService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/class"})
public class ClassController extends HttpServlet {

    @Inject
    private IClassService classService;

    @Inject
    private DTOEntityConverter dtoEntityConverter;

    private Gson gson = new Gson();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long classId = Long.parseLong(request.getParameter("id"));
        ClassEntity classEntity = classService.findById(classId);
        ClassDTO classDto = (ClassDTO)dtoEntityConverter.toDTO(classEntity, ClassDTO.class);
        String classDtoJson = gson.toJson(classDto);
        response.getWriter().write(classDtoJson);
    }
}
