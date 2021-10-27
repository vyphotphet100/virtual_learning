package com.webpro.virtual_learning.dao;

import com.webpro.virtual_learning.dto.LessonDTO;
import com.webpro.virtual_learning.entity.LessonEntity;

public interface ILessonDAO extends IBaseDAO<LessonEntity>{
    LessonEntity findById(Long id);
    void delete(Long id);
}
