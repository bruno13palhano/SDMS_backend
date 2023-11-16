package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.repository.CategoryRepository;
import com.bruno13palhano.data.repository.ProductRepository;
import com.bruno13palhano.model.Category;
import com.bruno13palhano.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@RequestMapping(path = "/products")
@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/all")
    Iterable<Product> getAll() {
        return productRepository.getAll();
    }

    @GetMapping("/insert")
    void insert() {
        Iterable<Category> categoryList = categoryRepository.getAll();
        Category c = categoryList.iterator().next();

        Product p1 = new Product(
                0L,
                "Homem",
                "3",
                "Perfume masculino",
                new byte[] {},
                1234591111L,
                List.of(c),
                "Natura"
        );

        productRepository.insert(p1);
    }
}
