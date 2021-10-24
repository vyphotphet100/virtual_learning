package com.webpro.virtual_learning.service.impl;

import com.webpro.virtual_learning.dto.BaseDTO;
import com.webpro.virtual_learning.service.IBaseService;


public abstract class BaseService<T> implements IBaseService<T> {
    protected BaseDTO exceptionObject(BaseDTO dto, String message) {
        dto.setHttpStatus(BaseDTO.HttpStatus.ERROR);
        dto.setMessage(message);
        return dto;
    }
}
