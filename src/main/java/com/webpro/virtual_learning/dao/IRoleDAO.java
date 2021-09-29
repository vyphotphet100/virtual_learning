package com.webpro.virtual_learning.dao;

import com.webpro.virtual_learning.dto.RoleDTO;

public interface IRoleDAO extends IBaseDAO<RoleDTO>{
    RoleDTO findById(Long id);
    void delete(Long id);
}
