package com.webpro.virtual_learning.service.impl;

import com.webpro.virtual_learning.converter.dto_entity.DTOEntityConverter;
import com.webpro.virtual_learning.entity.BaseEntity;
import com.webpro.virtual_learning.service.IBaseService;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;


public abstract class BaseService<D, E> implements IBaseService<D, E> {
    @Inject
    protected DTOEntityConverter dtoEntityConverter;

    public E exceptionObject(BaseEntity entity, String message) {
        entity.setHttpStatus(BaseEntity.HttpStatus.ERROR);
        entity.setMessage(message);
        return (E)entity;
    }

    protected String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
