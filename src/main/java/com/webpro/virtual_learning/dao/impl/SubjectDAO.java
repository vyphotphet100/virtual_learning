package com.webpro.virtual_learning.dao.impl;

import com.webpro.virtual_learning.dao.ISubjectDAO;
import com.webpro.virtual_learning.dto.RoleDTO;
import com.webpro.virtual_learning.dto.SubjectDTO;

import java.util.List;

public class SubjectDAO extends BaseDAO<SubjectDTO> implements ISubjectDAO {
    @Override
    public List<SubjectDTO> findAll() {
        String sql = "SELECT * FROM `subject`;";
        List<SubjectDTO> res = baseLowerDao.query(sql, SubjectDTO.class);
        return res;
    }

    @Override
    public SubjectDTO save(SubjectDTO dto) {
        String sql = "INSERT INTO `subject`(`name`) VALUE(?);";
        Long id = (Long)baseLowerDao.insert(sql, dto.getName());
        return this.findById(id);
    }

    @Override
    public SubjectDTO findById(Long id) {
        String sql = "SELECT * FROM `subject` WHERE `id` = " + id;
        List<SubjectDTO> res = baseLowerDao.query(sql, SubjectDTO.class);
        if (res.isEmpty())
            return null;
        return res.get(0);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM `subject` WHERE `id` = ?;";
        baseLowerDao.delete(sql, id);
    }
}
