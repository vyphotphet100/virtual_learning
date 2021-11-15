package com.webpro.virtual_learning.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public abstract class BaseEntity {
    public enum HttpStatus {
        OK,
        ERROR
    };

    @Transient
    private List<Object> listResult = new ArrayList<>();

    @Transient
    private String message;

    @Transient
    private String verificationCode;

    @Transient
    private HttpStatus httpStatus = HttpStatus.OK;

    @Transient
    private List<Object> listRequest = new ArrayList<>();
}
