package com.webpro.virtual_learning.service;

import com.webpro.virtual_learning.dto.UserDTO;
import com.webpro.virtual_learning.entity.UserEntity;

public interface IUserService extends IBaseService<UserDTO, UserEntity>{
    UserEntity findByUsername(String username);
    UserEntity findByUsernameAndPassword(String username, String password);
    void delete(String username);

    void deleteDoneQuestions(Long questionId);
    void deleteJoinedClass(Long classId);

    void joinClass(String username, Long classId);
}
