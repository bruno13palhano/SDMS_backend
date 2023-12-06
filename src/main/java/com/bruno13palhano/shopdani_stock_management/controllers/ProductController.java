package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.service.ProductService;
import com.bruno13palhano.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/products")
@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok().body(productService.getAll());
    }

    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody Product product) {
        productService.insert(product);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody Product product) {
        productService.update(product);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        productService.delete(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
