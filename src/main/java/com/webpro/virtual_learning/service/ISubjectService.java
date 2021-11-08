package com.webpro.virtual_learning.service;

import com.webpro.virtual_learning.dto.SubjectDTO;
import com.webpro.virtual_learning.entity.SubjectEntity;

import java.util.List;

public interface ISubjectService extends IBaseService<SubjectDTO, SubjectEntity>{
    SubjectEntity findById(Long id);
    void delete(Long id);

    List<SubjectEntity> findAllWithNumberOfClass(Integer numOfClass);
}
