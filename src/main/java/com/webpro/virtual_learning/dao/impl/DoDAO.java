package com.webpro.virtual_learning.dao.impl;

import com.webpro.virtual_learning.dao.IDoDAO;
import com.webpro.virtual_learning.dto.DoDTO;

import java.util.List;

public class DoDAO extends BaseDAO<DoDTO> implements IDoDAO {
    @Override
    public List<DoDTO> findAll() {
        String sql = "SELECT * FROM `do`;";
        List<DoDTO> res = baseLowerDao.query(sql, DoDTO.class);
        return res;
    }

    @Override
    public DoDTO save(DoDTO dto) {
        String sql = "INSERT INTO `do`(`username`, `question_id`) VALUE(?, ?);";
        baseLowerDao.insert(sql, dto.getUsername(), dto.getQuestionId());
        return this.findByUsernameAndQuestionId(dto.getUsername(), dto.getQuestionId());
    }

    @Override
    public DoDTO findByUsernameAndQuestionId(String username, Long questionId) {
        String sql = "SELECT * FROM `do` WHERE `username` = '" + username + "' AND `question_id` = " + questionId;
        List<DoDTO> res = baseLowerDao.query(sql, DoDTO.class);
        if (res.isEmpty())
            return null;
        return res.get(0);
    }

    @Override
    public void delete(String username, Long questionId) {
        String sql = "DELETE FROM `do` WHERE `username` = ? AND `question_id` = ?;";
        baseLowerDao.delete(sql, username, questionId);
    }
}
