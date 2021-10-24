package com.webpro.virtual_learning.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class BaseDTO {
    public enum HttpStatus {
        OK,
        ERROR
    };
    private List<Object> resultList = new ArrayList<>();
    private List<Object> requestList = new ArrayList<>();
    private HttpStatus httpStatus = HttpStatus.OK;
    private String message;
}
