package com.webpro.virtual_learning.service.impl;

import com.webpro.virtual_learning.converter.dto_entity.DTOEntityConverter;
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

    @Inject
    private DTOEntityConverter dtoEntityConverter;

    @Override
    public List<LessonEntity> findAll() {
        return null;
    }

    @Override
    public LessonEntity save(LessonDTO dto) {
        LessonEntity lessonEntity = (LessonEntity) dtoEntityConverter.toEntity(dto, LessonEntity.class);
        lessonEntity = lessonDao.save(lessonEntity);

        if (lessonEntity == null)
            return this.exceptionObject(new LessonEntity(), "Something went wrong.");

        lessonEntity.setMessage("Add lesson successfully.");
        return lessonEntity;
    }

    @Override
    public LessonEntity update(LessonDTO dto) {
        if (lessonDao.findById(dto.getId()) == null)
            return this.exceptionObject(new LessonEntity(), "This lesson does not exist.");

        LessonEntity lessonEntity = (LessonEntity) dtoEntityConverter.toEntity(dto, LessonEntity.class);
        lessonEntity = lessonDao.update(lessonEntity);

        if (lessonEntity == null)
            return this.exceptionObject(new LessonEntity(), "Something went wrong.");

        lessonEntity.setMessage("Update lesson successfully.");
        return lessonEntity;
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
        List<LessonEntity> lessonEntities = lessonDao.findAll();
        for (LessonEntity lessonEntity: lessonEntities)
            if (lessonEntity.getClazz().getId().equals(classId))
                this.delete(lessonEntity.getId());
    }
}
