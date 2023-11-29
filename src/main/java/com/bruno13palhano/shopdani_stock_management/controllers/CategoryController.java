package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.repository.CategoryRepository;
import com.bruno13palhano.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/categories")
@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/all")
    ResponseEntity<Iterable<Category>> getAll() {
        return ResponseEntity.ok().body(categoryRepository.getAll());
    }

    @PostMapping(path = "/insert")
    void insert(@RequestBody Category category) {
        categoryRepository.insert(category);
    }

    @PutMapping(path = "/update")
    void update(@RequestBody Category category) {
        categoryRepository.update(category);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        categoryRepository.deleteById(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
