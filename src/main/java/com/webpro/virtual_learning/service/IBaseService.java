package com.webpro.virtual_learning.service;

import com.webpro.virtual_learning.dto.UserDTO;

import java.util.List;

public interface IBaseService<T> {
    List<T> findAll();
    T save(T userDto);
    T update(T userDto);
}
