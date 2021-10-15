package com.webpro.virtual_learning.dao;

import com.webpro.virtual_learning.dto.SubjectDTO;

public interface ISubjectDAO extends IBaseDAO<SubjectDTO>{
    SubjectDTO findById(Long id);
    void delete(Long id);
}
