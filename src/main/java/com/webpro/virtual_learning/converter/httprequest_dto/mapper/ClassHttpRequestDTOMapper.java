package com.webpro.virtual_learning.converter.httprequest_dto.mapper;

import com.webpro.virtual_learning.dto.ClassDTO;

import javax.servlet.http.HttpServletRequest;

public class ClassHttpRequestDTOMapper extends BaseHttpRequestDTOMapper<ClassDTO>{
    @Override
    public ClassDTO mapToDTO(HttpServletRequest request) {
        ClassDTO classDto = new ClassDTO();
        try {
            classDto.setId(Long.parseLong(request.getParameter("id")));
        } catch (Exception ex){
            classDto.setId(null);
        }
        classDto.setName(request.getParameter("name"));
        try {
            classDto.setSubjectId(Long.parseLong(request.getParameter("subjectId")));
        } catch (Exception ex){
            classDto.setSubjectId(null);
        }
        classDto.setDescription(request.getParameter("description"));
        classDto.setPassword(request.getParameter("password"));
        classDto.setAuthorUsername(request.getParameter("authorUsername"));

        return classDto;
    }
}
