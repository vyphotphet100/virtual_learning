package com.webpro.virtual_learning.service;

import com.webpro.virtual_learning.dto.UserDTO;

import java.util.List;

public interface IUserService extends IBaseService<UserDTO>{
    UserDTO findByUsername(String username);
    UserDTO findByUsernameAndPassword(String username, String password);
    void delete(String username);
}
