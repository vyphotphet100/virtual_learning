package com.webpro.virtual_learning.converter.dto_entity;

import com.webpro.virtual_learning.dao.IClassDAO;
import com.webpro.virtual_learning.dao.ILessonDAO;
import com.webpro.virtual_learning.dao.IQuestionDAO;
import com.webpro.virtual_learning.dao.IUserDAO;
import com.webpro.virtual_learning.dto.*;
import com.webpro.virtual_learning.entity.*;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;

public class DTOEntityConverter {
    public BaseDTO toDTO(BaseEntity entity, Class tClass) {
        if (entity == null)
            return null;

        ModelMapper modelMap = new ModelMapper();
        BaseDTO resObj = (BaseDTO) modelMap.map(entity, tClass);
        return this.dtoObject(entity, resObj);
    }

    public BaseEntity toEntity(BaseDTO dto, Class tClass) {
        if (dto == null)
            return null;

        ModelMapper modelMap = new ModelMapper();
        BaseEntity resObj = (BaseEntity) modelMap.map(dto, tClass);
        return this.entityObject(dto, resObj);
    }

    private BaseDTO dtoObject(BaseEntity entity, BaseDTO dto) {
        if (dto.getClass() == ClassDTO.class) {
            ClassDTO resDto = (ClassDTO) dto;
            ClassEntity resEntity = (ClassEntity) entity;

            resDto.setAuthorUsername(resEntity.getAuthorUser().getUsername());

            // joined users
            for (UserEntity userEntity : resEntity.getJoinedUser())
                resDto.getJoinedUsernames().add(userEntity.getUsername());

            // lessons
            for (LessonEntity lessonEntity : resEntity.getLessons())
                resDto.getLessonIds().add(lessonEntity.getId());

            return resDto;
        } else if (dto.getClass() == LessonDTO.class) {
            LessonDTO resDto = (LessonDTO) dto;
            LessonEntity resEntity = (LessonEntity) entity;

            resDto.setClassId(resEntity.getClazz().getId());

            // questions
            for (QuestionEntity questionEntity : resEntity.getQuestions())
                resDto.getQuestionIds().add(questionEntity.getId());

            return resDto;
        } else if (dto.getClass() == QuestionDTO.class) {
            QuestionDTO resDto = (QuestionDTO) dto;
            QuestionEntity resEntity = (QuestionEntity) entity;

            // users
            for (UserEntity userEntity : resEntity.getUsers())
                resDto.getUsernames().add(userEntity.getUsername());

            return resDto;
        } else if (dto.getClass() == RoleDTO.class) {
            RoleDTO resDto = (RoleDTO) dto;
            RoleEntity resEntity = (RoleEntity) entity;

            // users
            for (UserEntity userEntity : resEntity.getUsers())
                resDto.getUsernames().add(userEntity.getUsername());

            return resDto;
        } else if (dto.getClass() == SubjectDTO.class) {
            SubjectDTO resDto = (SubjectDTO) dto;
            SubjectEntity resEntity = (SubjectEntity) entity;

            // classes
            for (ClassEntity classEntity : resEntity.getClasses())
                resDto.getClassIds().add(classEntity.getId());

            return resDto;
        } else if (dto.getClass() == UserDTO.class) {
            UserDTO resDto = (UserDTO) dto;
            UserEntity resEntity = (UserEntity) entity;

            // created classes
            for (ClassEntity classEntity : resEntity.getCreatedClasses())
                resDto.getCreatedClassIds().add(classEntity.getId());

            // joined classes
            for (ClassEntity classEntity : resEntity.getJoinedClasses())
                resDto.getJoinedClassIds().add(classEntity.getId());

            // done questions
            for (QuestionEntity questionEntity : resEntity.getDoneQuestions())
                resDto.getDoneQuestionIds().add(questionEntity.getId());

            return resDto;
        }

        return dto;
    }

    @Inject
    private IClassDAO classDao;

    @Inject
    private IUserDAO userDao;

    @Inject
    private ILessonDAO lessonDao;

    @Inject
    private IQuestionDAO questionDao;

    private BaseEntity entityObject(BaseDTO dto, BaseEntity entity) {
        if (entity.getClass() == ClassEntity.class) {
            ClassDTO resDto = (ClassDTO) dto;
            ClassEntity resEntity = (ClassEntity) entity;

            resEntity.setAuthorUser(userDao.findById(resDto.getAuthorUsername()));

            // joined users
            if (resDto.getJoinedUsernames() != null)
                for (String username : resDto.getJoinedUsernames()) {
                    UserEntity userEntity = userDao.findById(username);
                    if (userEntity != null)
                        resEntity.getJoinedUser().add(userEntity);
                }

            // lessons
            if (resDto.getLessonIds() != null)
                for (Long id : resDto.getLessonIds()) {
                    LessonEntity lessonEntity = lessonDao.findById(id);
                    if (lessonEntity != null)
                        resEntity.getLessons().add(lessonEntity);
                }

            return resEntity;
        } else if (entity.getClass() == LessonEntity.class) {
            LessonDTO resDto = (LessonDTO) dto;
            LessonEntity resEntity = (LessonEntity) entity;

            resEntity.setClazz(classDao.findById(resDto.getClassId()));

            // questions
            if (resDto.getQuestionIds() != null)
                for (Long id : resDto.getQuestionIds()) {
                    QuestionEntity questionEntity = questionDao.findById(id);
                    if (questionEntity != null)
                        resEntity.getQuestions().add(questionEntity);
                }

            return resEntity;
        } else if (entity.getClass() == QuestionEntity.class) {
            QuestionDTO resDto = (QuestionDTO) dto;
            QuestionEntity resEntity = (QuestionEntity) entity;

            // users
            if (resDto.getUsernames() != null)
                for (String username : resDto.getUsernames()) {
                    UserEntity userEntity = userDao.findById(username);
                    if (userEntity != null)
                        resEntity.getUsers().add(userEntity);
                }

            return resEntity;
        } else if (entity.getClass() == RoleEntity.class) {
            RoleDTO resDto = (RoleDTO) dto;
            RoleEntity resEntity = (RoleEntity) entity;

            // users
            if (resDto.getUsernames() != null)
                for (String username : resDto.getUsernames()) {
                    UserEntity userEntity = userDao.findById(username);
                    if (userEntity != null)
                        resEntity.getUsers().add(userEntity);
                }

            return resEntity;
        } else if (entity.getClass() == SubjectEntity.class) {
            SubjectDTO resDto = (SubjectDTO) dto;
            SubjectEntity resEntity = (SubjectEntity) entity;

            // classes
            if (resDto.getClassIds() != null)
                for (Long id : resDto.getClassIds()) {
                    ClassEntity classEntity = classDao.findById(id);
                    if (classEntity != null)
                        resEntity.getClasses().add(classEntity);
                }

            return resEntity;
        } else if (entity.getClass() == UserEntity.class) {
            UserDTO resDto = (UserDTO) dto;
            UserEntity resEntity = (UserEntity) entity;

            // created classes
            if (resDto.getCreatedClassIds() != null)
                for (Long id : resDto.getCreatedClassIds()) {
                    ClassEntity classEntity = classDao.findById(id);
                    if (classEntity != null)
                        resEntity.getCreatedClasses().add(classEntity);
                }

            // joined classes
            if (resDto.getJoinedClassIds() != null)
                for (Long id : resDto.getJoinedClassIds()) {
                    ClassEntity classEntity = classDao.findById(id);
                    if (classEntity != null)
                        resEntity.getJoinedClasses().add(classEntity);
                }

            // done questions
            if (resDto.getDoneQuestionIds() != null)
                for (Long id : resDto.getDoneQuestionIds()) {
                    QuestionEntity questionEntity = questionDao.findById(id);
                    if (questionEntity != null)
                        resEntity.getDoneQuestions().add(questionEntity);
                }

            return resEntity;
        }
        return entity;
    }
}
