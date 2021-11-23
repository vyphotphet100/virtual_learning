package com.webpro.virtual_learning.controller.student.clazz;

import com.webpro.virtual_learning.constant.Constant;
import com.webpro.virtual_learning.entity.ClassEntity;
import com.webpro.virtual_learning.entity.UserEntity;
import com.webpro.virtual_learning.service.IClassService;
import com.webpro.virtual_learning.service.IUserService;
import com.webpro.virtual_learning.utils.MyUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/student/class/join"})
public class JoinClassController extends HttpServlet {

    @Inject
    private IClassService classService;

    @Inject
    private IUserService userService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Long classId = null;
        String password = null;
        try {
            classId = Long.parseLong(request.getParameter("classId"));
            password = request.getParameter("password");
        }catch (Exception ex) {
            request.setAttribute("message", "Invalid password or class does not exist.");
            request.getRequestDispatcher("/announce.jsp").forward(request, response);
            return;
        }

        UserEntity userSession = MyUtil.getUserFromSession(request);
        if (userSession == null)
            return;
        if (!userSession.getRole().getCode().equals(Constant.ROLE_STUDENT)) {
            request.setAttribute("message", "You are not student. Please use student account to continue.");
            request.getRequestDispatcher("/announce.jsp").forward(request, response);
            return;
        }


        if (classId == null || password == null) {
            request.setAttribute("message", "Invalid password or class does not exist.");
            request.getRequestDispatcher("/announce.jsp").forward(request, response);
            return;
        }

        ClassEntity classEntity = classService.findById(classId);
        if (classEntity.getPassword().equals(password)) {
            userService.joinClass(userSession.getUsername(), classId);
            request.getSession().setAttribute(Constant.USER_SESSION, userService.findByUsername(userSession.getUsername()));
            response.sendRedirect("/student/lesson?id=" + classEntity.getLessons().get(0).getId());
        }
        else {
            request.setAttribute("message", "Invalid password.");
            request.getRequestDispatcher("/announce.jsp").forward(request, response);
        }

    }
}
