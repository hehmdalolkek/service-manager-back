package com.hehmdalolkek.spring.servicemanagerback.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CategoryIsNotEmptyAdvice {

    @ResponseBody
    @ExceptionHandler(CategoryIsNotEmptyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> exceptionHandler(CategoryIsNotEmptyException exception){

        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("errorMessage",exception.getMessage());

        return errorMap;

    }
}
