package com.webpro.virtual_learning.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class SubjectDTO extends BaseDTO{
    private Long id;
    private String name;
    private List<Long> classIds = new ArrayList<>();
}
