package com.hehmdalolkek.spring.servicemanagerback.exceptions;

public class ServiceNotFoundException extends RuntimeException{
    public ServiceNotFoundException(int id){
        super("Could not found the employee with id "+ id);
    }
}
