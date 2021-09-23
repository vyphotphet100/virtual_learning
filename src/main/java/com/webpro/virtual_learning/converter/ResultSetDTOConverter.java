package com.webpro.virtual_learning.converter;

import com.webpro.virtual_learning.dto.BaseDTO;
import com.webpro.virtual_learning.dto.RoleDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetDTOConverter {
    public BaseDTO toDTO(ResultSet rs, Class tClass) {
        if (tClass == RoleDTO.class) {
            RoleDTO roleDto = new RoleDTO();
            try {
                roleDto.setId(rs.getLong("id"));
                roleDto.setCode(rs.getString("code"));
                return roleDto;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }

        }
        return null;
    }
}
