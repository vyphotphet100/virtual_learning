package com.webpro.virtual_learning.service.impl;

import com.webpro.virtual_learning.dao.IClassDAO;
import com.webpro.virtual_learning.dao.ISubjectDAO;
import com.webpro.virtual_learning.dto.ClassDTO;
import com.webpro.virtual_learning.entity.ClassEntity;
import com.webpro.virtual_learning.entity.SubjectEntity;
import com.webpro.virtual_learning.service.IClassService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ClassService extends BaseService<ClassDTO, ClassEntity> implements IClassService {
    @Inject
    private IClassDAO classDao;

    @Inject
    private ISubjectDAO subjectDao;

    @Override
    public List<ClassEntity> findAll() {
        return classDao.findAll();
    }

    @Override
    public ClassEntity save(ClassDTO dto) {
        return null;
    }

    @Override
    public ClassEntity update(ClassDTO dto) {
        return null;
    }

    @Override
    public ClassEntity findById(Long id) {
        return null;
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
}
