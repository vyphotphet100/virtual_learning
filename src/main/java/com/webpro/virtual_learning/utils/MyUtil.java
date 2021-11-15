package com.webpro.virtual_learning.utils;

import com.webpro.virtual_learning.constant.Constant;
import com.webpro.virtual_learning.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

public class MyUtil {
    public static String generateRandomString(Integer length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static UserEntity getUserFromSession(HttpServletRequest request) {
        try {
            UserEntity userEntity = (UserEntity) request.getSession().getAttribute(Constant.USER_SESSION);
            return userEntity;
        } catch (Exception ex) {
            return null;
        }
    }
}
