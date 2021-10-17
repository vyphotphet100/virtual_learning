package com.webpro.virtual_learning.dao;

import com.webpro.virtual_learning.dto.DoDTO;

public interface IDoDAO extends IBaseDAO<DoDTO>{
    DoDTO findByUsernameAndQuestionId(String username, Long questionId);
    void delete(String username, Long questionId);
}
