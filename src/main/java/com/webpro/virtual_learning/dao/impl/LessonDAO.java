package com.webpro.virtual_learning.dao.impl;

import com.webpro.virtual_learning.dao.ILessonDAO;
import com.webpro.virtual_learning.dto.JoinDTO;
import com.webpro.virtual_learning.dto.LessonDTO;
import com.webpro.virtual_learning.dto.RoleDTO;

import java.util.List;

public class LessonDAO extends BaseDAO<LessonDTO> implements ILessonDAO {
    @Override
    public List<LessonDTO> findAll() {
        String sql = "SELECT * FROM `lesson`;";
        List<LessonDTO> res = baseLowerDao.query(sql, LessonDTO.class);
        return res;
    }

    @Override
    public LessonDTO save(LessonDTO dto) {
        String sql = "INSERT INTO `lesson`(`title`, `description`, `video`, `class_id`) VALUE(?, ?, ?, ?);";
        Long id = (Long)baseLowerDao.insert(sql, dto.getTitle(), dto.getDescription(), dto.getVideo(), dto.getClassId());
        return this.findById(id);
    }

    @Override
    public LessonDTO findById(Long id) {
        String sql = "SELECT * FROM `lesson` WHERE `id` = " + id;
        List<LessonDTO> res = baseLowerDao.query(sql, LessonDTO.class);
        if (res.isEmpty())
            return null;
        return res.get(0);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM `lesson` WHERE `id` = ?;";
        baseLowerDao.delete(sql, id);
    }
}
