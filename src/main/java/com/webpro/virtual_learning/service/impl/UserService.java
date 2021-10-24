package com.webpro.virtual_learning.service.impl;

import com.webpro.virtual_learning.dao.IUserDAO;
import com.webpro.virtual_learning.dto.UserDTO;
import com.webpro.virtual_learning.service.IUserService;

import javax.inject.Inject;
import java.util.List;

public class UserService extends BaseService implements IUserService {

    @Inject
    private IUserDAO userDao;

    @Override
    public List<UserDTO> findAll() {
        return userDao.findAll();
    }

    @Override
    public UserDTO findByUsername(String username) {
        return null;
    }

    @Override
    public UserDTO save(UserDTO userDto) {
        return null;
    }

    @Override
    public UserDTO update(UserDTO userDto) {
        return null;
    }

    @Override
    public void delete(String username) {

    }
}
