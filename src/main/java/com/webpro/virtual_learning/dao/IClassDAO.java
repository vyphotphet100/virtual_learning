package com.webpro.virtual_learning.dao;

import com.webpro.virtual_learning.dto.ClassDTO;

public interface IClassDAO extends IBaseDAO<ClassDTO>{
    ClassDTO findById(Long id);
    void delete(Long id);
}
