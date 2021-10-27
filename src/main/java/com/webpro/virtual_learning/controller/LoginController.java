package com.webpro.virtual_learning.controller;

import com.webpro.virtual_learning.converter.HttpRequestDTOConverter;
import com.webpro.virtual_learning.dto.BaseDTO;
import com.webpro.virtual_learning.dto.UserDTO;
import com.webpro.virtual_learning.service.IUserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/log-in")
public class LoginController extends HttpServlet {

    @Inject
    private HttpRequestDTOConverter requestDTOConverter;

    @Inject
    private IUserService userService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDTO userDto = (UserDTO)request.getSession().getAttribute("userDto");
        UserDTO requestDto = (UserDTO) requestDTOConverter.toDTO(request, UserDTO.class);
        UserDTO responseDto = userService.findByUsernameAndPassword(requestDto.getUsername(), requestDto.getPassword());
        request.setAttribute("responseDto", responseDto);
        if (responseDto.getHttpStatus().equals(BaseDTO.HttpStatus.ERROR)) {
            request.getSession().setAttribute("userDto", null);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        else {
            // save user to session
            request.getSession().setAttribute("userDto", responseDto);
            response.sendRedirect("/home");
        }
    }
}
