package com.webpro.virtual_learning.service;

import com.webpro.virtual_learning.dto.QuestionDTO;
import com.webpro.virtual_learning.entity.QuestionEntity;

public interface IQuestionService extends IBaseService<QuestionDTO, QuestionEntity>{
    QuestionEntity findById(Long id);
    void delete(Long id);
    void deleteByLessonId(Long lessonId);
}
