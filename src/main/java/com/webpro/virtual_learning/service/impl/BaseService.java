package com.webpro.virtual_learning.service.impl;

import com.webpro.virtual_learning.converter.dto_entity.DTOEntityConverter;
import com.webpro.virtual_learning.entity.BaseEntity;
import com.webpro.virtual_learning.service.IBaseService;

import javax.inject.Inject;


public abstract class BaseService<D, E> implements IBaseService<D, E> {
    @Inject
    protected DTOEntityConverter dtoEntityConverter;

    protected E exceptionObject(BaseEntity entity, String message) {
        entity.setHttpStatus(BaseEntity.HttpStatus.ERROR);
        entity.setMessage(message);
        return (E)entity;
    }
}
