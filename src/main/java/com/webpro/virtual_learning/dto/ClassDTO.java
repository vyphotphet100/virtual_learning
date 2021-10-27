package com.webpro.virtual_learning.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ClassDTO extends BaseDTO{
    private Long id;
    private String name;
    private String description;
    private String password;
    private String authorUsername;
    private List<String> joinedUsernames = new ArrayList<>();
    private List<Long> lessonIds = new ArrayList<>();
    private Long subjectId;
}
