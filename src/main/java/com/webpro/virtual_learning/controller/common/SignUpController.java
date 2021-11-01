package com.webpro.virtual_learning.controller.common;

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
        UserDTO userDto = requestDTOConverter.toDTO(request, userHttpRequestDTOMapper);
        UserDTO responseDto = userService.save(userDto);
        request.setAttribute("responseDto", responseDto);

        if (responseDto.getHttpStatus().equals(BaseDTO.HttpStatus.OK)) {
            response.sendRedirect("/log-in?message=" + responseDto.getMessage());
        } else {
            this.doGet(request, response);
        }
    }
}
