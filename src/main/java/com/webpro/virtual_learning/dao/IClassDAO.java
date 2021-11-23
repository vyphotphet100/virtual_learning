package com.webpro.virtual_learning.dao;

import com.webpro.virtual_learning.entity.ClassEntity;

import java.util.List;

public interface IClassDAO extends IBaseDAO<ClassEntity>{
    ClassEntity findById(Long id);
    void delete(Long id);

    List<ClassEntity> findAllByName(String name);
}
