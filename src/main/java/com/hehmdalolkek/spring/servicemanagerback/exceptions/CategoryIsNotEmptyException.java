package com.hehmdalolkek.spring.servicemanagerback.exceptions;

public class CategoryIsNotEmptyException extends RuntimeException {

    public CategoryIsNotEmptyException(int id) {
        super("The category with id = " + id + " contains services and cannot be deleted.");
    }
}
