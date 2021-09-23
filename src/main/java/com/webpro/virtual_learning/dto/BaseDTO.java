package com.webpro.virtual_learning.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

enum HttpStatus {
    OK,
    ERROR
};

@Getter
@Setter
public abstract class BaseDTO {
    private List<Object> resultList = new ArrayList<>();
    private List<Object> requestList = new ArrayList<>();
    private HttpStatus httpStatus = HttpStatus.OK;
    private String message;
}
