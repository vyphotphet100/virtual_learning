package com.webpro.virtual_learning.converter.httprequest_dto.mapper;

import com.webpro.virtual_learning.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserHttpRequestDTOMapper extends BaseHttpRequestDTOMapper<UserDTO> {
    @Override
    public UserDTO mapToDTO(HttpServletRequest request) {
        UserDTO userDto = new UserDTO();
        userDto.setUsername((String) request.getParameter("username"));
        userDto.setPassword((String) request.getParameter("password"));
        userDto.setRetypePassword((String) request.getParameter("retypePassword"));
        userDto.setFullName((String) request.getParameter("fullName"));
        userDto.setEmail((String) request.getParameter("email"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (request.getParameter("birthday") != null)
                userDto.setBirthday(new Date(format.parse(request.getParameter("birthday")).getTime()));
        } catch (ParseException e) {
        }
        userDto.setPhone((String) request.getParameter("phone"));
        userDto.setAvatar((String) request.getParameter("avatar"));
        try {
            userDto.setRoleId(Long.parseLong(request.getParameter("roleId")));
        } catch (Exception ex){
            userDto.setRoleId(null);
        }

        return userDto;
    }
}
