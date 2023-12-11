package com.hehmdalolkek.spring.servicemanagerback.service;


import com.hehmdalolkek.spring.servicemanagerback.dao.CategoryRepository;
import com.hehmdalolkek.spring.servicemanagerback.dao.ServiceRepository;
import com.hehmdalolkek.spring.servicemanagerback.entity.Service;
import com.hehmdalolkek.spring.servicemanagerback.exceptions.CategoryNotFoundException;
import com.hehmdalolkek.spring.servicemanagerback.exceptions.ServiceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;
import java.util.List;

@org.springframework.stereotype.Service
@Validated
public class ServiceServiceImpl implements ServiceService {

    private ServiceRepository serviceRepository;
    private CategoryRepository categoryRepository;

    @Override
    public Service getServiceById(int id) {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new ServiceNotFoundException(id));
    }

    @Override
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public void editServiceById(int id, @Valid Service newService) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new ServiceNotFoundException(id));

        service.setTitle(newService.getTitle());
        service.setCategory(newService.getCategory());
        service.setDuration(newService.getDuration());
        service.setPrice(newService.getPrice());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        service.setChange_date(timestamp.toInstant());

        serviceRepository.save(service);
    }

    @Override
    public void addService(@Valid Service service) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        service.setChange_date(timestamp.toInstant());

        serviceRepository.save(service);
    }

    @Override
    public void deleteServiceById(int id) {
        if (!serviceRepository.existsById(id)) {
            throw new ServiceNotFoundException(id);
        }

        serviceRepository.deleteById(id);
    }

    @Override
    public List<Service> getServicesByCategoryId(int id) {
        categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));

        return serviceRepository.findAllByCategoryId(id);
    }

    @Autowired
    public void setServiceRepository(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
