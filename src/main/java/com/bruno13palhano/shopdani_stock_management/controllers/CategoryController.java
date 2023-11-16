package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.repository.CategoryRepository;
import com.bruno13palhano.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/categories")
@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/all")
    Iterable<Category> getAll() {
        return categoryRepository.getAll();
    }

    @GetMapping("/insert")
    void insert() {
        categoryRepository.insert(new Category(0L, "Perfumes"));
        categoryRepository.insert(new Category(0L, "Sabonetes"));
        categoryRepository.insert(new Category(0L, "Outros"));
    }
}
