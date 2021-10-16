package com.webpro.virtual_learning.dao;

import com.webpro.virtual_learning.dto.LessonDTO;

public interface ILessonDAO extends IBaseDAO<LessonDTO>{
    LessonDTO findById(Long id);
    void delete(Long id);
}
