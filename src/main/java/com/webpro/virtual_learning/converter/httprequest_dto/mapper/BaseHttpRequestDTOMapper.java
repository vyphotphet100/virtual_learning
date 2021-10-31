package com.webpro.virtual_learning.converter.httprequest_dto.mapper;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseHttpRequestDTOMapper<D> {
    public D mapToDTO(HttpServletRequest request) {
        return null;
    }
}
