package com.webpro.virtual_learning.controller.common;

import com.webpro.virtual_learning.constant.Constant;
import com.webpro.virtual_learning.converter.httprequest_dto.HttpRequestDTOConverter;
import com.webpro.virtual_learning.converter.httprequest_dto.mapper.UserHttpRequestDTOMapper;
import com.webpro.virtual_learning.dto.BaseDTO;
import com.webpro.virtual_learning.dto.UserDTO;
import com.webpro.virtual_learning.service.IUserService;
import com.webpro.virtual_learning.utils.CookieUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/log-in", "/login"})
public class LogInController extends HttpServlet {

    @Inject
    private HttpRequestDTOConverter requestDTOConverter;

    @Inject
    private IUserService userService;

    @Inject
    private UserHttpRequestDTOMapper userHttpRequestDTOMapper;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (CookieUtil.checkUserInCookieOrSession(request)) {
            this.doPost(request, response);
            return;
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDTO requestDto = null;
        UserDTO responseDto = null;

        // LOG IN BY COOKIE
        String username = CookieUtil.getValue(request, "username");
        String password = CookieUtil.getValue(request, "password");
        if (username != null &&
                password != null) {
            responseDto = userService.findByUsernameAndPassword(username, password);
            this.checkLoginRedirect(request, response, requestDto, responseDto);
            return;
        }

        // LOG IN BY SESSION
        UserDTO sessionDto = (UserDTO) request.getSession().getAttribute(Constant.USER_SESSION);
        if (sessionDto != null) { // log in by session
            responseDto = userService.findByUsernameAndPassword(sessionDto.getUsername(), sessionDto.getPassword());
            this.checkLoginRedirect(request, response, requestDto, responseDto);
            return;
        }

        // LOG IN BY CLICK BUTTON
        requestDto = requestDTOConverter.toDTO(request, userHttpRequestDTOMapper);
        responseDto = userService.findByUsernameAndPassword(requestDto.getUsername(), requestDto.getPassword());
        this.checkLoginRedirect(request, response, requestDto, responseDto);
    }

    private void checkLoginRedirect(HttpServletRequest request, HttpServletResponse response, UserDTO requestDto, UserDTO responseDto) throws ServletException, IOException {
        request.setAttribute("responseDto", responseDto);

        // LOG IN FAIL
        if (responseDto.getHttpStatus().equals(BaseDTO.HttpStatus.ERROR)) {
            CookieUtil.removeUserInCookieAndSession(request, response);
            this.doGet(request, response);
            return;
        }

        // LOG IN SUCCESSFULLY
        // save user to session
        request.getSession().setAttribute(Constant.USER_SESSION, responseDto);

        // save user cookie if user require
        if (request.getParameter("rememberMe") != null &&
                request.getParameter("rememberMe").equals("yes")) {
            CookieUtil.setCookie(response, "username", requestDto.getUsername(), 5 * 60);
            CookieUtil.setCookie(response, "password", requestDto.getPassword(), 5 * 60);
        }

        response.sendRedirect("/home");
    }
}
