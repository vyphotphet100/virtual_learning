package com.webpro.virtual_learning.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JoinDTO extends BaseDTO{
    private String username;
    private Long classId;
}
