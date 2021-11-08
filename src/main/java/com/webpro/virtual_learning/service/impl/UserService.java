package com.webpro.virtual_learning.service.impl;

import com.webpro.virtual_learning.dao.IUserDAO;
import com.webpro.virtual_learning.dto.UserDTO;
import com.webpro.virtual_learning.entity.UserEntity;
import com.webpro.virtual_learning.service.IUserService;

import javax.inject.Inject;
import java.util.List;

public class UserService extends BaseService<UserDTO, UserEntity> implements IUserService {

    @Inject
    private IUserDAO userDao;

    @Override
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

    @Override
    public UserEntity findByUsername(String username) {
        UserEntity userEntity = userDao.findById(username);
        if (userEntity == null)
            return this.exceptionObject(new UserEntity(), "This username does not exists.");

        return userEntity;
    }

    @Override
    public UserEntity findByUsernameAndPassword(String username, String password) {
        UserEntity userEntity = userDao.findById(username);
        if (userEntity == null)
            return exceptionObject(new UserEntity(), "This username does not exist.");
        if (!userEntity.getPassword().equals(password))
            return exceptionObject(new UserEntity(), "Wrong password.");

        userEntity.setMessage("Login successfully.");
        return userEntity;
    }

    @Override
    public UserEntity save(UserDTO userDto) {
        if (userDao.findById(userDto.getUsername()) != null)
            return this.exceptionObject(new UserEntity(), "This username exists.");

        UserEntity userEntity = userDao.save((UserEntity) dtoEntityConverter.toEntity(userDto, UserEntity.class));
        userEntity.setMessage("Register successfully.");
        return userEntity;
    }

    @Override
    public UserEntity update(UserDTO userDto) {
        return null;
    }

    @Override
    public void delete(String username) {

    }
}
