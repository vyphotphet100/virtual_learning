package com.webpro.virtual_learning.service.impl;

import com.webpro.virtual_learning.converter.dto_entity.DTOEntityConverter;
import com.webpro.virtual_learning.dao.IClassDAO;
import com.webpro.virtual_learning.dao.ISubjectDAO;
import com.webpro.virtual_learning.dao.IUserDAO;
import com.webpro.virtual_learning.dto.ClassDTO;
import com.webpro.virtual_learning.entity.ClassEntity;
import com.webpro.virtual_learning.entity.SubjectEntity;
import com.webpro.virtual_learning.entity.UserEntity;
import com.webpro.virtual_learning.service.IClassService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ClassService extends BaseService<ClassDTO, ClassEntity> implements IClassService {
    @Inject
    private IClassDAO classDao;

    @Inject
    private ISubjectDAO subjectDao;

    @Inject
    private IUserDAO userDao;

    @Inject
    private DTOEntityConverter dtoEntityConverter;

    @Override
    public List<ClassEntity> findAll() {
        return classDao.findAll();
    }

    @Override
    public ClassEntity save(ClassDTO dto) {
        ClassEntity classEntity = (ClassEntity)this.dtoEntityConverter.toEntity(dto, ClassEntity.class);
        classEntity = classDao.save(classEntity);
        classEntity.setMessage("Add class successfully");
        return classEntity;
    }

    @Override
    public ClassEntity update(ClassDTO dto) {
        if (classDao.findById(dto.getId()) == null)
            return this.exceptionObject(new ClassEntity(), "This class does not exist");

        ClassEntity classEntity = (ClassEntity)dtoEntityConverter.toEntity(dto, ClassEntity.class);
        classEntity = classDao.update(classEntity);
        classEntity.setMessage("Update class successfully");
        return classEntity;
    }

    @Override
    public ClassEntity findById(Long id) {
        return classDao.findById(id);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ClassEntity> findBySubjectId(Long subjectId) {
        SubjectEntity subjectEntity = subjectDao.findById(subjectId);
        if (subjectEntity == null)
            return new ArrayList<>();

        return subjectEntity.getClasses();
    }

    @Override
    public List<ClassEntity> findAllByAuthorUsername(String username) {
        UserEntity userEntity = userDao.findById(username);
        if (userEntity == null)
            return new ArrayList<>();

        return userEntity.getCreatedClasses();
    }
}
