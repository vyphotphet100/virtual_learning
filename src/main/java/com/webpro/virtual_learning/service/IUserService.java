package com.webpro.virtual_learning.service;

import com.webpro.virtual_learning.dto.UserDTO;

import java.util.List;

public interface IUserService extends IBaseService{
    List<UserDTO> findAll();
    UserDTO findByUsername(String username);
    UserDTO save(UserDTO userDto);
    UserDTO update(UserDTO userDto);
    void delete(String username);
}
