package com.hehmdalolkek.spring.servicemanagerback.exceptions;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(int id){
        super("Could not found the department with id "+ id);
    }
}
