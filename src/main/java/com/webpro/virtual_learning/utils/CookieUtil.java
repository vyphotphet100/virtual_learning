package com.webpro.virtual_learning.utils;

import com.webpro.virtual_learning.constant.Constant;
import com.webpro.virtual_learning.dto.UserDTO;
import com.webpro.virtual_learning.entity.UserEntity;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static String getValue(HttpServletRequest request, String cName) {
        Cookie cookies[] = request.getCookies();
        for (Cookie c: cookies){
            if (c.getName().equals(cName))
                return c.getValue();
        }
        return null;
    }

    public static void setCookie(HttpServletResponse response, String cName, String cValue, Integer maxAge) {
        Cookie c = new Cookie(cName, cValue);
        c.setMaxAge(maxAge);
        c.setPath("/");
        response.addCookie(c);
    }

    public static Boolean checkUserInCookieOrSession(HttpServletRequest request) {
        String username = CookieUtil.getValue(request, "username");
        String password = CookieUtil.getValue(request, "password");
        UserEntity sessionEntity = (UserEntity) request.getSession().getAttribute(Constant.USER_SESSION);
        if ((username != null && !username.equals("") && !username.equals("null") &&
                password != null && !password.equals("") && !password.equals("null")) ||
                sessionEntity != null) {
            return true;
        }

        return false;
    }

    public static void removeUserInCookieAndSession(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute(Constant.USER_SESSION, null);
        CookieUtil.setCookie(response, "username", null, 1);
        CookieUtil.setCookie(response, "password", null, 1);
    }
}
