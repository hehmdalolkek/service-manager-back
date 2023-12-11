package com.hehmdalolkek.spring.servicemanagerback.controller;

import com.hehmdalolkek.spring.servicemanagerback.entity.Service;
import com.hehmdalolkek.spring.servicemanagerback.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class ServiceRestController {

    private ServiceService serviceService;

    @GetMapping("/services/{id}")
    public Service getServiceById(@PathVariable("id") int id) {
        return serviceService.getServiceById(id);
    }

    @GetMapping("/services")
    public List<Service> getAllServices() {
        return serviceService.getAllServices();
    }

    @PostMapping("/services")
    public void addService(@RequestBody Service service) {
        serviceService.addService(service);
    }

    @PutMapping("/services/{id}")
    public void editServiceById(@PathVariable("id") int id, @RequestBody Service service) {
        serviceService.editServiceById(id, service);
    }

    @DeleteMapping("/services/{id}")
    public void deleteServiceById(@PathVariable("id") int id) {
        serviceService.deleteServiceById(id);
    }

    @GetMapping("/categories/{id}/services")
    public List<Service> getServicesByCategoryId(@PathVariable("id") int id) {
        return serviceService.getServicesByCategoryId(id);
    }

    @Autowired
    public void setServiceService(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

}
