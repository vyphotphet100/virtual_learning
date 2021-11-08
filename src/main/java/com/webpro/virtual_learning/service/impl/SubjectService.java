package com.webpro.virtual_learning.service.impl;

import com.webpro.virtual_learning.dao.ISubjectDAO;
import com.webpro.virtual_learning.dto.SubjectDTO;
import com.webpro.virtual_learning.entity.ClassEntity;
import com.webpro.virtual_learning.entity.SubjectEntity;
import com.webpro.virtual_learning.service.ISubjectService;

import javax.inject.Inject;
import java.util.List;

public class SubjectService extends BaseService<SubjectDTO, SubjectEntity> implements ISubjectService {
    @Inject
    private ISubjectDAO subjectDao;

    @Override
    public List<SubjectEntity> findAll() {
        return subjectDao.findAll();
    }

    @Override
    public SubjectEntity save(SubjectDTO dto) {
        return null;
    }

    @Override
    public SubjectEntity update(SubjectDTO dto) {
        return null;
    }

    @Override
    public SubjectEntity findById(Long id) {
        return subjectDao.findById(id);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<SubjectEntity> findAllWithNumberOfClass(Integer numOfClass) {
        List<SubjectEntity> subjectEntities = subjectDao.findAll();
        for (SubjectEntity subjectEntity: subjectEntities) {
            List<ClassEntity> classEntities = subjectEntity.getClasses();
            while (classEntities.size() > numOfClass)
                classEntities.remove((int)numOfClass);

            subjectEntity.setClasses(classEntities);
        }

        return subjectEntities;
    }
}
