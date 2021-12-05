package com.webpro.virtual_learning.service.impl;

import com.webpro.virtual_learning.converter.dto_entity.DTOEntityConverter;
import com.webpro.virtual_learning.dao.IQuestionDAO;
import com.webpro.virtual_learning.dto.QuestionDTO;
import com.webpro.virtual_learning.entity.LessonEntity;
import com.webpro.virtual_learning.entity.QuestionEntity;
import com.webpro.virtual_learning.service.IQuestionService;
import com.webpro.virtual_learning.service.IUserService;

import javax.inject.Inject;
import java.util.List;

public class QuestionService extends BaseService<QuestionDTO, QuestionEntity> implements IQuestionService {

    @Inject
    private IQuestionDAO questionDao;

    @Inject
    private DTOEntityConverter dtoEntityConverter;

    @Override
    public List<QuestionEntity> findAll() {
        return null;
    }

    @Override
    public QuestionEntity save(QuestionDTO dto) {
        QuestionEntity questionEntity = (QuestionEntity)dtoEntityConverter.toEntity(dto, QuestionEntity.class);
        questionEntity = questionDao.save(questionEntity);

        if (questionEntity == null)
            return this.exceptionObject(new QuestionEntity(), "Something went wrong.");

        questionEntity.setMessage("Add question successfully.");
        return questionEntity;
    }

    @Override
    public QuestionEntity update(QuestionDTO dto) {
        if (questionDao.findById(dto.getId()) == null)
            return this.exceptionObject(new QuestionEntity(), "This question does not exist.");

        QuestionEntity questionEntity = (QuestionEntity)dtoEntityConverter.toEntity(dto, QuestionEntity.class);
        questionEntity = questionDao.update(questionEntity);

        if (questionEntity == null)
            return this.exceptionObject(new QuestionEntity(), "Something went wrong.");

        questionEntity.setMessage("Update question successfully.");
        return questionEntity;
    }

    @Override
    public QuestionEntity findById(Long id) {
        return questionDao.findById(id);
    }

    @Inject
    private IUserService userService;

    @Override
    public void delete(Long id) {
        userService.deleteDoneQuestions(id);
        questionDao.delete(id);
    }

    @Override
    public void deleteByLessonId(Long lessonId) {
        List<QuestionEntity> questionEntities = questionDao.findAll();
        for (QuestionEntity questionEntity: questionEntities) {
            if (questionEntity.getLesson().getId().equals(lessonId))
                this.delete(questionEntity.getId());
        }
    }
}
