package com.webpro.virtual_learning.dao;

import com.webpro.virtual_learning.dto.JoinDTO;

public interface IJoinDAO extends IBaseDAO<JoinDTO>{
    JoinDTO findByUsernameAndClassId(String username, Long id);
    void delete(String username, Long id);
}
