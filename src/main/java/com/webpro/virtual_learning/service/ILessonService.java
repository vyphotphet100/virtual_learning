package com.webpro.virtual_learning.service;

import com.webpro.virtual_learning.dto.LessonDTO;
import com.webpro.virtual_learning.entity.LessonEntity;

public interface ILessonService extends IBaseService<LessonDTO, LessonEntity>{
    LessonEntity findById(Long lessonId);
    void delete(Long lessonId);
}
