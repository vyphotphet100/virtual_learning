package com.webpro.virtual_learning.controller;

import com.webpro.virtual_learning.converter.dto_entity.DTOEntityConverter;
import com.webpro.virtual_learning.dao.*;
import com.webpro.virtual_learning.dto.*;
import com.webpro.virtual_learning.entity.*;

import java.io.*;
import javax.inject.Inject;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "test", value = "/test/*")
public class HelloServlet extends HttpServlet {

    @Inject
    private IClassDAO classDao;

    @Inject
    private DTOEntityConverter converter;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ClassEntity classEntity = classDao.findById(1L);
        ClassDTO classDto = (ClassDTO) converter.toDTO(classEntity, ClassDTO.class);
        ClassEntity classEntity2 = (ClassEntity) converter.toEntity(classDto, ClassEntity.class);


    }

    public void destroy() {
    }
}