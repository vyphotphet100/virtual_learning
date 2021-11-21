package com.webpro.virtual_learning.controller.student.clazz;

import com.webpro.virtual_learning.entity.ClassEntity;
import com.webpro.virtual_learning.entity.UserEntity;
import com.webpro.virtual_learning.service.IClassService;
import com.webpro.virtual_learning.utils.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/student/my-class"})
public class MyClassController extends HttpServlet {

    @Autowired
    private IClassService classService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserEntity userEntity = MyUtil.getUserFromSession(request);
        if (userEntity == null)
            return;

        request.setAttribute("classes", userEntity.getJoinedClasses());

        request.getRequestDispatcher("/student/my-class-student.jsp").forward(request, response);
    }
}
