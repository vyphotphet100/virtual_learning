package com.webpro.virtual_learning.controller.common;

import com.webpro.virtual_learning.constant.Constant;
import com.webpro.virtual_learning.entity.UserEntity;
import com.webpro.virtual_learning.utils.MyUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/my-class"})
public class MyClassController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserEntity userSession = MyUtil.getUserFromSession(request);
        if (userSession == null) {
            response.sendRedirect("/login");
            return;
        }

        if (userSession.getRole().getCode().equals(Constant.ROLE_TEACHER))
            response.sendRedirect("/teacher/my-class");
        else if (userSession.getRole().getCode().equals(Constant.ROLE_STUDENT))
            response.sendRedirect("/student/my-class");
    }
}
