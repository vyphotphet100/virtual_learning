package com.webpro.virtual_learning.dao;

import com.webpro.virtual_learning.dto.SubjectDTO;
import com.webpro.virtual_learning.entity.SubjectEntity;

public interface ISubjectDAO extends IBaseDAO<SubjectEntity>{
    SubjectEntity findById(Long id);
    void delete(Long id);
}
