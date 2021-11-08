package com.webpro.virtual_learning.service;

import com.webpro.virtual_learning.entity.BaseEntity;

import java.util.List;

public interface IBaseService<D, E> {
    E exceptionObject(BaseEntity entity, String message);
    List<E> findAll();
    E save(D dto);
    E update(D dto);
}
