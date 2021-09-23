package com.webpro.virtual_learning.dao.impl;
import com.webpro.virtual_learning.dao.IRoleDAO;
import com.webpro.virtual_learning.dto.RoleDTO;

import java.util.List;

public class RoleDAO extends BaseDAO<RoleDTO> implements IRoleDAO{
    @Override
    public List<RoleDTO> findAll() {
        String sql = "SELECT * FROM `role`;";
        List<RoleDTO> res = baseLowerDao.query(sql, RoleDTO.class);
        return res;
    }

    @Override
    public RoleDTO save(RoleDTO dto) {
        String sql = "INSERT INTO `role`(`code`) VALUE(?);";
        Long id = (Long)baseLowerDao.insert(sql, dto.getCode());
        return this.findById(id);
    }

    @Override
    public RoleDTO update(RoleDTO dto) {
        if (dto.getId() == null)
            return null;

        StringBuilder sql = new StringBuilder("UPDATE `role` SET ");






        String sql = "INSERT INTO `role`(`id`, `code`) VALUE(?, ?);";
        Long id = (Long)baseLowerDao.insert(sql, dto.getCode());
        return this.findById(id);
    }

    @Override
    public RoleDTO findById(Long id) {
        String sql = "SELECT * FROM `role` WHERE `id` = " + id;
        List<RoleDTO> res = baseLowerDao.query(sql, RoleDTO.class);
        if (res.isEmpty())
            return null;
        return res.get(0);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM `role` WHERE `id` = ?;";
        baseLowerDao.delete(sql, id);
    }
}
