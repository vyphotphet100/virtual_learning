package com.webpro.virtual_learning.controller.teacher.clazz;

import com.webpro.virtual_learning.entity.ClassEntity;
import com.webpro.virtual_learning.service.IClassService;
import lombok.SneakyThrows;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/teacher/delete-class"})
public class DeleteClassController extends HttpServlet {

    @Inject
    private IClassService classService;

    @SneakyThrows
    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException{
        Long classId = Long.parseLong(request.getParameter("id"));
        ClassEntity classEntity = classService.findById(classId);
        if (classEntity == null)
            throw new Exception("Class does not exist");

        classService.delete(classId);
    }
}
