package com.webpro.virtual_learning.controller.common;

import com.webpro.virtual_learning.dao.ISubjectDAO;
import com.webpro.virtual_learning.entity.SubjectEntity;
import com.webpro.virtual_learning.service.IClassService;
import com.webpro.virtual_learning.service.ISubjectService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    @Inject
    private IClassService classService;

    @Inject
    private ISubjectService subjectService;

    @Inject
    private ISubjectDAO subjectDao;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
        request.setCharacterEncoding("UTF-8");
        // check viewAll param
        String viewAll = request.getParameter("viewAll");
        if (viewAll != null &&
                !viewAll.equals("")) {
            if (viewAll.equals("all")) { // view all classes
                List<SubjectEntity> subjectEntities = subjectDao.findAll();
                request.setAttribute("subjectEntities", subjectEntities);

                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }

            // view classes in one subject
            SubjectEntity subjectEntity = subjectService.findById(Long.parseLong(viewAll));
            if (subjectEntity != null) {
                request.setAttribute("subjectEntity", subjectEntity);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }
        }

        // view 4 classes in each subject
        List<SubjectEntity> subjectEntities = subjectService.findAllWithNumberOfClass(3);
        request.setAttribute("subjectEntities", subjectEntities);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
