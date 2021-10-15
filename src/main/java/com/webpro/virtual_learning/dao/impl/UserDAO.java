package com.webpro.virtual_learning.dao.impl;

import com.webpro.virtual_learning.dao.IUserDAO;
import com.webpro.virtual_learning.dto.RoleDTO;
import com.webpro.virtual_learning.dto.UserDTO;

import java.util.Date;
import java.util.List;

public class UserDAO extends BaseDAO<UserDTO> implements IUserDAO {

    @Override
    public List<UserDTO> findAll() {
        String sql = "SELECT * FROM `user`;";
        List<UserDTO> res = baseLowerDao.query(sql, UserDTO.class);
        return res;
    }

    @Override
    public UserDTO save(UserDTO dto) {
        String sql = "INSERT INTO `user`(`username`, `password`, `full_name`, `email`, `birthday`, `phone`, `avatar`, `role_code`) " +
                "VALUE(?, ?, ?, ?, ?, ?, ?, ?);";
        String username = (String)baseLowerDao.insert(sql, dto.getUsername(), dto.getPassword(), dto.getFullName(),
                dto.getEmail(), dto.getBirthday(), dto.getPhone(), dto.getAvatar(), dto.getRoleCode());
        return this.findById(username);
    }

    @Override
    public UserDTO findById(String username) {
        String sql = "SELECT * FROM `user` WHERE `username` = '" + username + "'";
        List<UserDTO> res = baseLowerDao.query(sql, UserDTO.class);
        if (res.isEmpty())
            return null;
        return res.get(0);
    }

    @Override
    public void delete(String username) {
        String sql = "DELETE FROM `user` WHERE `username` = ?;";
        baseLowerDao.delete(sql, username);
    }
}
