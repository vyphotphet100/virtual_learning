package com.webpro.virtual_learning.service.impl;

import com.webpro.virtual_learning.converter.DTOEntityConverter;
import com.webpro.virtual_learning.dto.BaseDTO;
import com.webpro.virtual_learning.service.IBaseService;

import javax.inject.Inject;


public abstract class BaseService<T> implements IBaseService<T> {
    @Inject
    protected DTOEntityConverter dtoEntityConverter;

    protected BaseDTO exceptionObject(BaseDTO dto, String message) {
        dto.setHttpStatus(BaseDTO.HttpStatus.ERROR);
        dto.setMessage(message);
        return dto;
    }
}
