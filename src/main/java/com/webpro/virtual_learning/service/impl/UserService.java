package com.webpro.virtual_learning.service.impl;

import com.webpro.virtual_learning.dao.IClassDAO;
import com.webpro.virtual_learning.dao.IQuestionDAO;
import com.webpro.virtual_learning.dao.IUserDAO;
import com.webpro.virtual_learning.dto.UserDTO;
import com.webpro.virtual_learning.entity.ClassEntity;
import com.webpro.virtual_learning.entity.QuestionEntity;
import com.webpro.virtual_learning.entity.UserEntity;
import com.webpro.virtual_learning.service.IUserService;
import com.webpro.virtual_learning.utils.GoogleCloudUtil;

import javax.inject.Inject;
import java.util.Base64;
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

        if (userEntity == null)
            return this.exceptionObject(new UserEntity(), "Something's wrong");

        userEntity.setMessage("Register successfully.");
        return userEntity;
    }

    @Override
    public UserEntity update(UserDTO userDto) {
        if (userDao.findById(userDto.getUsername()) == null)
            return this.exceptionObject(new UserEntity(), "This username does not exist");

        // save avatar if it has new value
        if (userDto.getAvatar().contains(",")) {
            byte[] pictueBytes = Base64.getDecoder().decode(userDto.getAvatar().split(",")[1]);
            String fileName = "user_" + userDto.getUsername() + "_avatar.png";
            if (!GoogleCloudUtil.upFileToGoogleCloud(fileName, pictueBytes))
                return this.exceptionObject(new UserEntity(), "Something's wrong when adding avatar picture");

            GoogleCloudUtil.getFileFromGoogleCloud(fileName);
            userDto.setAvatar("/file?name=" + fileName);
        }

        UserEntity userEntity = (UserEntity) dtoEntityConverter.toEntity(userDto, UserEntity.class);
        userEntity.setJoinedClasses(null);
        userEntity.setCreatedClasses(null);
        userEntity.setDoneQuestions(null);
        userEntity = userDao.update(userEntity);

        if (userEntity == null)
            return this.exceptionObject(new UserEntity(), "Something's wrong");

        userEntity.setMessage("Update information successfully");
        return userEntity;
    }

    @Override
    public void delete(String username) {

    }

    @Inject
    private IQuestionDAO questionDao;

    @Override
    public void deleteDoneQuestions(Long questionId) {
        QuestionEntity questionEntity = questionDao.findById(questionId);
        if (questionEntity == null)
            return;

        for (UserEntity userEntity : questionEntity.getUsers()) {
            userEntity.getDoneQuestions().remove(questionEntity);
            userDao.update(userEntity);
        }
    }

    @Inject
    private IClassDAO classDao;

    @Override
    public void deleteJoinedClass(Long classId) {
        ClassEntity classEntity = classDao.findById(classId);
        if (classEntity == null)
            return;

        for (UserEntity userEntity : classEntity.getJoinedUser()) {
            userEntity.getJoinedClasses().remove(classEntity);
            userDao.update(userEntity);
        }
    }

    @Override
    public void joinClass(String username, Long classId) {
        UserEntity userEntity = userDao.findById(username);
        ClassEntity classEntity = classDao.findById(classId);

        List<ClassEntity> joinedClasses = userEntity.getJoinedClasses();
        for (ClassEntity classEntity1 : joinedClasses)
            if (classEntity1.getId().equals(classId))
                return;

        userEntity.getJoinedClasses().add(classEntity);
        userDao.update(userEntity);
    }
}
