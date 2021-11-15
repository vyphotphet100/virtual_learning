package com.webpro.virtual_learning.controller;

import com.webpro.virtual_learning.converter.dto_entity.DTOEntityConverter;
import com.webpro.virtual_learning.dao.IClassDAO;
import com.webpro.virtual_learning.utils.GoogleCloudUtil;
import org.springframework.util.ResourceUtils;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ResourceBundle;

@WebServlet(name = "test", value = "/test")
public class TestController extends HttpServlet {

    @Inject
    private IClassDAO classDao;

    @Inject
    private DTOEntityConverter converter;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void destroy() {
    }
}