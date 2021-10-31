package com.webpro.virtual_learning.converter.httprequest_dto;

import com.webpro.virtual_learning.converter.httprequest_dto.mapper.BaseHttpRequestDTOMapper;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestDTOConverter {
    public <D> D toDTO(HttpServletRequest request, BaseHttpRequestDTOMapper<D> mapper) {
        return mapper.mapToDTO(request);
    }
}
