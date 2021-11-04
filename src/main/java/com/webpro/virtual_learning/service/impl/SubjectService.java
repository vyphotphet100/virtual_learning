package com.webpro.virtual_learning.service.impl;

import com.webpro.virtual_learning.dao.ISubjectDAO;
import com.webpro.virtual_learning.dto.SubjectDTO;
import com.webpro.virtual_learning.entity.SubjectEntity;
import com.webpro.virtual_learning.service.ISubjectService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class SubjectService extends BaseService<SubjectDTO> implements ISubjectService {
    @Inject
    private ISubjectDAO subjectDao;

    @Override
    public List<SubjectDTO> findAll() {
        List<SubjectDTO> subjectDtos = new ArrayList<>();
        for (SubjectEntity subjectEntity: subjectDao.findAll())
            subjectDtos.add((SubjectDTO) this.dtoEntityConverter.toDTO(subjectEntity, SubjectDTO.class));

        return subjectDtos;
    }

    @Override
    public SubjectDTO save(SubjectDTO userDto) {
        return null;
    }

    @Override
    public SubjectDTO update(SubjectDTO userDto) {
        return null;
    }

    @Override
    public SubjectDTO findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
