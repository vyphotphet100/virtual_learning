package com.webpro.virtual_learning.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class QuestionDTO extends BaseDTO{
    private Long id;
    private String content;
    private String option;
    private Integer correct;
    private Long lessonId;
}
