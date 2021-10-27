package com.webpro.virtual_learning.dao;

import com.webpro.virtual_learning.dto.ClassDTO;
import com.webpro.virtual_learning.entity.ClassEntity;

public interface IClassDAO extends IBaseDAO<ClassEntity>{
    ClassEntity findById(Long id);
    void delete(Long id);
}
