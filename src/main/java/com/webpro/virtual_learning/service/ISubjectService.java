package com.webpro.virtual_learning.service;

import com.webpro.virtual_learning.dto.SubjectDTO;

public interface ISubjectService extends IBaseService<SubjectDTO>{
    SubjectDTO findById(Long id);
    void delete(Long id);
}
