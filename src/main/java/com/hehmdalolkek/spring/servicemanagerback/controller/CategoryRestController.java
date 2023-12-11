package com.hehmdalolkek.spring.servicemanagerback.controller;

import com.hehmdalolkek.spring.servicemanagerback.entity.Category;
import com.hehmdalolkek.spring.servicemanagerback.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable("id") int id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/categories")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping("/categories/{id}")
    public void editCategoryById(@PathVariable("id") int id, @RequestBody Category category) {
        categoryService.editCategoryById(id, category);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategoryById(@PathVariable("id") int id) {
        categoryService.deleteCategoryById(id);
    }

}
