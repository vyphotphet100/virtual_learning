package com.webpro.virtual_learning.service.impl;

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

    @Override
    public List<QuestionEntity> findAll() {
        return null;
    }

    @Override
    public QuestionEntity save(QuestionDTO dto) {
        return null;
    }

    @Override
    public QuestionEntity update(QuestionDTO dto) {
        return null;
    }

    @Override
    public QuestionEntity findById(Long id) {
        return null;
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
        for (QuestionEntity questionEntity: questionDao.findAll()) {
            if (questionEntity.getLesson().getId().equals(lessonId))
                this.delete(questionEntity.getId());
        }
    }
}
