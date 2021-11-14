package com.webpro.virtual_learning.controller.common;

import com.webpro.virtual_learning.constant.Constant;
import com.webpro.virtual_learning.converter.httprequest_dto.HttpRequestDTOConverter;
import com.webpro.virtual_learning.converter.httprequest_dto.mapper.UserHttpRequestDTOMapper;
import com.webpro.virtual_learning.dto.UserDTO;
import com.webpro.virtual_learning.entity.BaseEntity;
import com.webpro.virtual_learning.entity.UserEntity;
import com.webpro.virtual_learning.service.IUserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/profile"})
public class ProfileController extends HttpServlet {

    @Inject
    private HttpRequestDTOConverter requestDTOConverter;

    @Inject
    private UserHttpRequestDTOMapper userMapper;

    @Inject
    private IUserService userService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
        request.setCharacterEncoding("UTF-8");

        UserDTO userDto = requestDTOConverter.toDTO(request, userMapper);
        UserEntity userEntity = userService.update(userDto);
        request.setAttribute("responseEntity", userEntity);
        if (userEntity.getHttpStatus() == BaseEntity.HttpStatus.OK)
            request.getSession().setAttribute(Constant.USER_SESSION, userEntity);

        this.doGet(request, response);
    }
}
