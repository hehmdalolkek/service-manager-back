package com.hehmdalolkek.spring.servicemanagerback.service;

import com.hehmdalolkek.spring.servicemanagerback.dao.CategoryRepository;
import com.hehmdalolkek.spring.servicemanagerback.entity.Category;
import com.hehmdalolkek.spring.servicemanagerback.exceptions.CategoryNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @Override
    @Transactional
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public void editCategoryById(int id, @Valid Category newCategory) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));

        category.setTitle(newCategory.getTitle());
        category.setServices(newCategory.getServices());
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void addCategory(@Valid Category category) {
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategoryById(int id) {
        if (!categoryRepository.existsById(id)) {
            throw new CategoryNotFoundException(id);
        }

        categoryRepository.deleteById(id);
    }
}
