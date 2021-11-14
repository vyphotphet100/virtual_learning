package com.webpro.virtual_learning.controller.teacher.clazz;

import com.webpro.virtual_learning.entity.ClassEntity;
import com.webpro.virtual_learning.entity.UserEntity;
import com.webpro.virtual_learning.service.IClassService;
import com.webpro.virtual_learning.utils.MyUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/teacher/my-class"})
public class MyClassController extends HttpServlet {
    @Inject
    private IClassService classService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserEntity userEntity = MyUtils.getUserFromSession(request);
        List<ClassEntity> classes = null;
        if (userEntity != null)
            classes = classService.findAllByAuthorUsername(userEntity.getUsername());
        else
            classes = classService.findAll();
        request.setAttribute("classes", classes);
        request.getRequestDispatcher("/teacher/my-class-teacher.jsp").forward(request, response);
    }
}
