package com.webpro.virtual_learning.filter;

import com.webpro.virtual_learning.constant.Constant;
import com.webpro.virtual_learning.entity.UserEntity;
import com.webpro.virtual_learning.utils.MyUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        String url = request.getRequestURI();
//        UserEntity userSession = MyUtil.getUserFromSession(request);
//
//        if (url.contains("/student/") || url.contains("/teacher/")) {
//            if (userSession == null) {
//                response.sendRedirect("/login");
//                //filterChain.doFilter(request, response);
//                return;
//            }
//        }
//
//        if (url.contains("/student/") && userSession.getRole().getCode().equals(Constant.ROLE_TEACHER)){
//            request.getSession().setAttribute(Constant.USER_SESSION, null);
//            response.sendRedirect("/login?message=" + "Please log in as student to continue");
//            //filterChain.doFilter(request, response);
//            return;
//        }
//
//        if (url.contains("/teacher/") && userSession.getRole().getCode().equals(Constant.ROLE_STUDENT)){
//            request.getSession().setAttribute(Constant.USER_SESSION, null);
//            response.sendRedirect("/login?message=" + "Please log in as teacher to continue");
//            //filterChain.doFilter(request, response);
//            return;
//        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        //Filter.super.destroy();
    }
}
