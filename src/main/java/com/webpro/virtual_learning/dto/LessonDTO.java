package com.webpro.virtual_learning.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LessonDTO extends BaseDTO{
    private Long id;
    private String title;
    private String description;
    private String video;
    private Long classId;
}
