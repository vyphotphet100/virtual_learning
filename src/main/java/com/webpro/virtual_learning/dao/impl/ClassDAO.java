package com.webpro.virtual_learning.dao.impl;

import com.webpro.virtual_learning.dao.IClassDAO;
import com.webpro.virtual_learning.dto.ClassDTO;
import com.webpro.virtual_learning.dto.UserDTO;

import java.util.List;

public class ClassDAO extends BaseDAO<ClassDTO> implements IClassDAO{
    @Override
    public List<ClassDTO> findAll() {
        String sql = "SELECT * FROM `class`;";
        List<ClassDTO> res = baseLowerDao.query(sql, ClassDTO.class);
        return res;
    }

    @Override
    public ClassDTO save(ClassDTO dto) {
        String sql = "INSERT INTO `class`(`name`, `description`, `password`, `author_username`, `subject_id`) " +
                "VALUE(?, ?, ?, ?, ?);";
        Long id = (Long)baseLowerDao.insert(sql, dto.getName(), dto.getDescription(), dto.getPassword(),
                dto.getAuthorUsername(), dto.getSubjectId());
        return this.findById(id);
    }

    @Override
    public ClassDTO findById(Long id) {
        String sql = "SELECT * FROM `class` WHERE `id` = " + id;
        List<ClassDTO> res = baseLowerDao.query(sql, ClassDTO.class);
        if (res.isEmpty())
            return null;
        return res.get(0);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM `class` WHERE `id` = ?;";
        baseLowerDao.delete(sql, id);
    }
}
