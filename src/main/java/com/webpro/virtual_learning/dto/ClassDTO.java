package com.webpro.virtual_learning.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClassDTO extends BaseDTO{
    private Long id;
    private String name;
    private String description;
    private String password;
    private String authorUsername;
    private Long subjectId;
}
