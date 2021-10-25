package com.webpro.virtual_learning.controller;

import com.webpro.virtual_learning.dto.*;
import com.webpro.virtual_learning.service.IUserService;

import java.io.*;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "test", value = "/test/*")
public class HelloServlet extends HttpServlet {

    @Inject
    private IUserService userService;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getPathInfo();
        String username = path.split("/")[1];
        String password = path.split("/")[2];
        UserDTO userDto = userService.findByUsernameAndPassword(username, password);

    }

    public void destroy() {
    }
}