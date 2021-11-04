package com.webpro.virtual_learning.service.impl;

import com.webpro.virtual_learning.dao.IClassDAO;
import com.webpro.virtual_learning.dto.ClassDTO;
import com.webpro.virtual_learning.entity.ClassEntity;
import com.webpro.virtual_learning.service.IClassService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ClassService extends BaseService<ClassDTO> implements IClassService {
    @Inject
    private IClassDAO classDao;

    @Override
    public List<ClassDTO> findAll() {
        List<ClassDTO> classDtos = new ArrayList<>();
        for (ClassEntity classEntity: classDao.findAll()) {
            classDtos.add((ClassDTO) this.dtoEntityConverter.toDTO(classEntity, ClassDTO.class));
        }

        return classDtos;
    }

    @Override
    public ClassDTO save(ClassDTO userDto) {
        return null;
    }

    @Override
    public ClassDTO update(ClassDTO userDto) {
        return null;
    }

    @Override
    public ClassDTO findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ClassDTO> findBySubjectId(Long subjectId) {
        List<ClassDTO> resDtos = new ArrayList<>();
        for (ClassDTO classDto: this.findAll())
            if (classDto.getSubjectId().equals(subjectId))
                resDtos.add(classDto);

        return resDtos;
    }
}
