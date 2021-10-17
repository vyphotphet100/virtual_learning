package com.webpro.virtual_learning.dao;

import com.webpro.virtual_learning.dto.QuestionDTO;

public interface IQuestionDAO extends IBaseDAO<QuestionDTO>{
    QuestionDTO findById(Long id);
    void delete(Long id);
}
