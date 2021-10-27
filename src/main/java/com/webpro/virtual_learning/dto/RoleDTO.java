package com.webpro.virtual_learning.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class RoleDTO extends BaseDTO{
    private Long id;
    private String code;
    private List<String> usernames = new ArrayList<>();
}
