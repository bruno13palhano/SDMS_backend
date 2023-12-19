package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.service.impl.DefaultCategoryService;
import com.bruno13palhano.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/categories")
@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    private DefaultCategoryService defaultCategoryService;

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok().body(defaultCategoryService.getAll());
    }

    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody Category category) {
        defaultCategoryService.insert(category);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody Category category) {
        defaultCategoryService.update(category);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        defaultCategoryService.delete(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
