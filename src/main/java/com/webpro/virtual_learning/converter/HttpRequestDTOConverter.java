package com.webpro.virtual_learning.converter;

import com.webpro.virtual_learning.dto.BaseDTO;
import com.webpro.virtual_learning.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HttpRequestDTOConverter {
    public BaseDTO toDTO(HttpServletRequest request, Class tClass) {
        if (tClass == UserDTO.class) {
            UserDTO userDto = new UserDTO();
            userDto.setUsername((String)request.getParameter("username"));
            userDto.setPassword((String)request.getParameter("password"));
            userDto.setFullName((String)request.getParameter("fullName"));
            userDto.setEmail((String)request.getParameter("email"));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                if (request.getParameter("birthday") != null)
                    userDto.setBirthday(new Date(format.parse(request.getParameter("birthday")).getTime()));
            } catch (ParseException e) {}
            userDto.setPhone((String)request.getParameter("phone"));
            userDto.setAvatar((String)request.getParameter("avatar"));
            userDto.setRoleId(Long.getLong(request.getParameter("roleId")));

            return userDto;
        }

        return null;
    }
}
