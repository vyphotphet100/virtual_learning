package com.webpro.virtual_learning.dao;
import com.webpro.virtual_learning.entity.RoleEntity;

public interface IRoleDAO extends IBaseDAO<RoleEntity>{
    RoleEntity findById(Long id);
    void delete(Long id);
}
