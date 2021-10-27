package com.webpro.virtual_learning.dao;

import com.webpro.virtual_learning.dto.QuestionDTO;
import com.webpro.virtual_learning.entity.QuestionEntity;

public interface IQuestionDAO extends IBaseDAO<QuestionEntity>{
    QuestionEntity findById(Long id);
    void delete(Long id);
}
