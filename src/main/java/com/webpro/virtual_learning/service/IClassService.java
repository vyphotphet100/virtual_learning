package com.webpro.virtual_learning.service;

import com.webpro.virtual_learning.dto.ClassDTO;
import com.webpro.virtual_learning.entity.ClassEntity;

import java.util.List;

public interface IClassService extends IBaseService<ClassDTO, ClassEntity>{
    ClassEntity findById(Long id);
    void delete(Long id);

    List<ClassEntity> findBySubjectId(Long subjectId);
}
