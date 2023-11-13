package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.repository.CategoryRepository;
import com.bruno13palhano.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/categories")
@RestController
@CrossOrigin
public class CategoryController {
    private List<Category> categories = List.of(
            new Category(0L, "Perfumes"),
            new Category(0L, "Sabonetes"),
            new Category(0L, "Outros")
    );

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/all")
    Iterable<Category> getAll() {
        return categoryRepository.getAll();
    }
}
