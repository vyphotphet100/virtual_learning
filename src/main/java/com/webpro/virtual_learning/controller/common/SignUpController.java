package com.webpro.virtual_learning.controller.common;

import com.webpro.virtual_learning.converter.httprequest_dto.HttpRequestDTOConverter;
import com.webpro.virtual_learning.converter.httprequest_dto.mapper.UserHttpRequestDTOMapper;
import com.webpro.virtual_learning.dto.BaseDTO;
import com.webpro.virtual_learning.dto.UserDTO;
import com.webpro.virtual_learning.entity.BaseEntity;
import com.webpro.virtual_learning.entity.UserEntity;
import com.webpro.virtual_learning.service.IUserService;
import com.webpro.virtual_learning.utils.CookieUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/sign-up"})
public class SignUpController extends HttpServlet {
    @Inject
    private HttpRequestDTOConverter requestDTOConverter;

    @Inject
    private UserHttpRequestDTOMapper userHttpRequestDTOMapper;

    @Inject
    private IUserService userService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (CookieUtil.checkUserInCookieOrSession(request)) {
            response.sendRedirect("/log-in");
            return;
        }
        request.getRequestDispatcher("/sign-up.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        UserDTO userDto = requestDTOConverter.toDTO(request, userHttpRequestDTOMapper);

        // check retype password
        if (!userDto.getPassword().equals(userDto.getRetypePassword())) {
            request.setAttribute("responseEntity", userService.exceptionObject(new UserEntity(), "Password confirmation failed"));
            this.doGet(request, response);
            return;
        }

        UserEntity responseEntity = userService.save(userDto);
        request.setAttribute("responseEntity", responseEntity);

        // save successfully
        if (responseEntity.getHttpStatus().equals(BaseEntity.HttpStatus.OK)) {
            response.sendRedirect("/log-in?message=" + responseEntity.getMessage());
            return;
        }

        // save failed
        this.doGet(request, response);

    }
}
