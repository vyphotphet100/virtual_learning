package com.webpro.virtual_learning.dao;

import com.webpro.virtual_learning.dto.BaseDTO;
import com.webpro.virtual_learning.dto.RoleDTO;
import com.webpro.virtual_learning.lowerdao.impl.BaseLowerDAO;

import java.util.List;

public interface IBaseDAO<T>{
    List<T> findAll();
    T save(T dto);
}
