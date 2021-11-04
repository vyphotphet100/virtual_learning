package com.webpro.virtual_learning.service;

import com.webpro.virtual_learning.dto.ClassDTO;

import java.util.List;

public interface IClassService extends IBaseService<ClassDTO>{
    ClassDTO findById(Long id);
    void delete(Long id);

    List<ClassDTO> findBySubjectId(Long subjectId);
}
