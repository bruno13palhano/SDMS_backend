package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.repository.ProductRepository;
import com.bruno13palhano.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/products")
@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/all")
    Iterable<Product> getAll() {
        return productRepository.getAll();
    }

    @PostMapping(path = "/insert")
    void insert(@RequestBody Product product) {
        productRepository.insert(product);
    }

    @PutMapping(path = "/update")
    void update(@RequestBody Product product) {
        productRepository.update(product);
    }

    @GetMapping("/delete/{id}")
    void delete(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
