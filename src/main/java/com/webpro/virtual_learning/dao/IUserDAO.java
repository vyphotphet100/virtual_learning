package com.webpro.virtual_learning.dao;

import com.webpro.virtual_learning.dto.UserDTO;

public interface IUserDAO extends IBaseDAO<UserDTO>{
    UserDTO findById(String username);
    void delete(String username);
}
