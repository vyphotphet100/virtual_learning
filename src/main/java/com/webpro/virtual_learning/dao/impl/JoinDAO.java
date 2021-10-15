package com.webpro.virtual_learning.dao.impl;

import com.webpro.virtual_learning.dao.IJoinDAO;
import com.webpro.virtual_learning.dto.ClassDTO;
import com.webpro.virtual_learning.dto.JoinDTO;
import com.webpro.virtual_learning.dto.RoleDTO;

import java.util.List;

public class JoinDAO extends BaseDAO<JoinDTO> implements IJoinDAO {
    @Override
    public List<JoinDTO> findAll() {
        String sql = "SELECT * FROM `join`;";
        List<JoinDTO> res = baseLowerDao.query(sql, JoinDTO.class);
        return res;
    }

    @Override
    public JoinDTO save(JoinDTO dto) {
        String sql = "INSERT INTO `join`(`username`, `class_id`) VALUE(?, ?);";
        baseLowerDao.insert(sql, dto.getUsername(), dto.getClassId());
        return this.findByUsernameAndClassId(dto.getUsername(), dto.getClassId());
    }

    @Override
    public JoinDTO findByUsernameAndClassId(String username, Long id) {
        String sql = "SELECT * FROM `join` WHERE `username` = '" + username + "' AND `class_id` = " + id;
        List<JoinDTO> res = baseLowerDao.query(sql, JoinDTO.class);
        if (res.isEmpty())
            return null;
        return res.get(0);
    }

    @Override
    public void delete(String username, Long id) {
        String sql = "DELETE FROM `join` WHERE `username` = ? AND `class_id` = ?;";
        baseLowerDao.delete(sql, username, id);
    }
}
