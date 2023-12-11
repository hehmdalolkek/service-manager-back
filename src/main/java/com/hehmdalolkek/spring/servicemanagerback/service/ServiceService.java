package com.hehmdalolkek.spring.servicemanagerback.service;

import com.hehmdalolkek.spring.servicemanagerback.entity.Service;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface ServiceService {

    public Service getServiceById(int id);

    public List<Service> getAllServices();

    public void editServiceById(int id, @Valid Service service);

    public void addService(@Valid Service service);

    public void deleteServiceById(int id);

    public List<Service> getServicesByCategoryId(int id);

}
