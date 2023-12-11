package com.hehmdalolkek.spring.servicemanagerback.dao;

import com.hehmdalolkek.spring.servicemanagerback.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Integer> {

    public List<Service> findAllByCategoryId(int id);

}
