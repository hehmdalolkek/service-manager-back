package com.hehmdalolkek.spring.servicemanagerback.dao;

import com.hehmdalolkek.spring.servicemanagerback.entity.Category;
import com.hehmdalolkek.spring.servicemanagerback.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
