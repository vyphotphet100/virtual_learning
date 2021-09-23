package com.webpro.virtual_learning.dao;

import com.webpro.virtual_learning.dto.RoleDTO;
import com.webpro.virtual_learning.lowerdao.impl.BaseLowerDAO;

import java.util.List;

public interface IRoleDAO extends IBaseDAO<RoleDTO>{
    RoleDTO findById(Long id);
    void delete(Long id);
}
