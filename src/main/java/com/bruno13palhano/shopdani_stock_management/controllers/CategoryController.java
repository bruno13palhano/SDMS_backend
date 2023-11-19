package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.repository.CategoryRepository;
import com.bruno13palhano.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/insert")
    void insert(@RequestBody Category category) {
        categoryRepository.insert(category);
    }

    @PutMapping(path = "/update")
    void update(@RequestBody Category category) {
        categoryRepository.update(category);
    }

    @GetMapping("/delete/{id}")
    void delete(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }
}
