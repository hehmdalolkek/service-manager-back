package com.hehmdalolkek.spring.servicemanagerback.dao;

import com.hehmdalolkek.spring.servicemanagerback.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
