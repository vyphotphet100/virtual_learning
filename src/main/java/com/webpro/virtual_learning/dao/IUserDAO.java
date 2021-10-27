package com.webpro.virtual_learning.dao;

import com.webpro.virtual_learning.dto.UserDTO;
import com.webpro.virtual_learning.entity.UserEntity;

public interface IUserDAO extends IBaseDAO<UserEntity>{
    UserEntity findById(String username);
    void delete(String username);
}
