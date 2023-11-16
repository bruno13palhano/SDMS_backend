package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.repository.ProductRepository;
import com.bruno13palhano.data.repository.StockOrderRepository;
import com.bruno13palhano.model.Items;
import com.bruno13palhano.model.Product;
import com.bruno13palhano.model.StockOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/items")
@RestController
@CrossOrigin
public class StockOrdersController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockOrderRepository stockOrderRepository;

    @GetMapping("/all")
    Iterable<Items> getAll() {
        stockOrderRepository.getAll().forEach( c -> System.out.println(c.getCategories()));
        return stockOrderRepository.getAll();
    }

    @GetMapping("/insert")
    void insert() {
        Iterable<Product> products = productRepository.getAll();
        Product p = products.iterator().next();
        System.out.println(p.getId());
        stockOrderRepository.insert(new StockOrder(
                0L,
                p.getId(),
                p.getName(),
                p.getPhoto(),
                123456L,
                234567L,
                10,
                p.getCategories().toString(),
                p.getCompany(),
                123.23F,
                321.32F,
                false,
                false
        ));
    }
}
