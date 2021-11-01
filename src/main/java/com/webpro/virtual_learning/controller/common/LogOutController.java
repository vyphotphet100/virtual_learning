package com.webpro.virtual_learning.controller.common;

import com.webpro.virtual_learning.constant.Constant;
import com.webpro.virtual_learning.utils.CookieUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/log-out", "/logout"})
public class LogOutController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CookieUtil.removeUserInCookieAndSession(request, response);
        response.sendRedirect("/log-in");
    }

}
