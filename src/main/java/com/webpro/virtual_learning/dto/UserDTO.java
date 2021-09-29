package com.webpro.virtual_learning.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter @Setter
public class UserDTO extends BaseDTO{
    private String username;
    private String password;
    private String fullName;
    private String email;
    private Date birthday;
    private String phone;
    private String avatar;
    private String roleCode;
}
