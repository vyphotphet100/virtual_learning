package com.webpro.virtual_learning.controller.common;

import com.webpro.virtual_learning.dao.ISubjectDAO;
import com.webpro.virtual_learning.dto.ClassDTO;
import com.webpro.virtual_learning.dto.SubjectDTO;
import com.webpro.virtual_learning.entity.SubjectEntity;
import com.webpro.virtual_learning.service.IClassService;
import com.webpro.virtual_learning.service.ISubjectService;
import com.webpro.virtual_learning.utils.CookieUtil;

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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get class by subject id
//        List<SubjectDTO> subjectDtos = subjectService.findAll();
//        for (SubjectDTO subjectDto: subjectDtos) {
//            List<ClassDTO> classDtosBySubjectId = classService.findBySubjectId(subjectDto.getId());
//            subjectDto.getResultList().add(classDtosBySubjectId);
//        }
//        request.setAttribute("subjectDtos", subjectDtos);

        List<SubjectEntity> subjectEntities = subjectDao.findAll();
        request.setAttribute("subjectEntities", subjectEntities);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
