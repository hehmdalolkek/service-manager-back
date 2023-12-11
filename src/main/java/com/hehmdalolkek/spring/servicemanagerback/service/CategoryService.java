package com.hehmdalolkek.spring.servicemanagerback.service;

import com.hehmdalolkek.spring.servicemanagerback.entity.Category;
import com.hehmdalolkek.spring.servicemanagerback.entity.Service;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface CategoryService {

    public Category getCategoryById(int id);

    public List<Category> getAllCategories();

    public void editCategoryById(int id, @Valid Category category);

    public void addCategory(@Valid Category category);

    public void deleteCategoryById(int id);

}
