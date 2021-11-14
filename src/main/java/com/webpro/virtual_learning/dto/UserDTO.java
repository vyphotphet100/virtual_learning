package com.webpro.virtual_learning.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class UserDTO extends BaseDTO{
    private String username;
    private String password;
    private String retypePassword;
    private String fullName;
    private String email;
    private Date birthday;
    private String phone;
    private String avatar;
    private Long roleId;
    private List<Long> createdClassIds = new ArrayList<>();
    private List<Long> joinedClassIds = new ArrayList<>();
    private List<Long> doneQuestionIds = new ArrayList<>();
}
