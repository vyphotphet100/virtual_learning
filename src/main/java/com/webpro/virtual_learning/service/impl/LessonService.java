package com.webpro.virtual_learning.service.impl;

import com.webpro.virtual_learning.dao.ILessonDAO;
import com.webpro.virtual_learning.dto.LessonDTO;
import com.webpro.virtual_learning.entity.LessonEntity;
import com.webpro.virtual_learning.service.ILessonService;
import com.webpro.virtual_learning.service.IQuestionService;

import javax.inject.Inject;
import java.util.List;

public class LessonService extends BaseService<LessonDTO, LessonEntity> implements ILessonService {
    @Inject
    private ILessonDAO lessonDao;

    @Override
    public List<LessonEntity> findAll() {
        return null;
    }

    @Override
    public LessonEntity save(LessonDTO dto) {
        return null;
    }

    @Override
    public LessonEntity update(LessonDTO dto) {
        return null;
    }

    @Override
    public LessonEntity findById(Long lessonId) {
        return lessonDao.findById(lessonId);
    }

    @Inject
    private IQuestionService questionService;

    @Override
    public void delete(Long lessonId) {
        // delete question
        questionService.deleteByLessonId(lessonId);
        lessonDao.delete(lessonId);
    }

    @Override
    public void deleteByClassId(Long classId) {
        for (LessonEntity lessonEntity: lessonDao.findAll())
            if (lessonEntity.getClazz().getId().equals(classId))
                this.delete(lessonEntity.getId());
    }
}
