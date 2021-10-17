package com.webpro.virtual_learning.dao.impl;

import com.webpro.virtual_learning.dao.IQuestionDAO;
import com.webpro.virtual_learning.dto.QuestionDTO;

import java.util.List;

public class QuestionDAO extends BaseDAO<QuestionDTO> implements IQuestionDAO {
    @Override
    public List<QuestionDTO> findAll() {
        String sql = "SELECT * FROM `question`;";
        List<QuestionDTO> res = baseLowerDao.query(sql, QuestionDTO.class);
        return res;
    }

    @Override
    public QuestionDTO save(QuestionDTO dto) {
        String sql = "INSERT INTO `question`(`content`, `option`, `correct`, `lesson_id`) VALUE(?, ?, ?, ?);";
        Long id = (Long)baseLowerDao.insert(sql, dto.getContent(), dto.getOption(), dto.getCorrect(), dto.getLessonId());
        return this.findById(id);
    }

    @Override
    public QuestionDTO findById(Long id) {
        String sql = "SELECT * FROM `question` WHERE `id` = " + id;
        List<QuestionDTO> res = baseLowerDao.query(sql, QuestionDTO.class);
        if (res.isEmpty())
            return null;
        return res.get(0);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM `question` WHERE `id` = ?;";
        baseLowerDao.delete(sql, id);
    }
}
