package com.webpro.virtual_learning.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class LessonDTO extends BaseDTO{
    private Long id;
    private String title;
    private String description;
    private String video;
    private Long classId;
    private List<Long> questionIds = new ArrayList<>();
}
