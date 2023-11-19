package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.repository.StockOrderRepository;
import com.bruno13palhano.model.StockOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/items")
@RestController
@CrossOrigin
public class StockOrdersController {

    @Autowired
    private StockOrderRepository stockOrderRepository;

    @GetMapping(path = "/all")
    Iterable<StockOrder> getAll() {
        return stockOrderRepository.getAll();
    }

    @PostMapping(path = "/insert")
    void insert(@RequestBody StockOrder stockOrder) {
        stockOrderRepository.insert(stockOrder);
    }

    @PutMapping(path = "update")
    void update(@RequestBody StockOrder stockOrder) {
        stockOrderRepository.update(stockOrder);
    }

    @GetMapping(path = "/delete/{id}")
    void delete(@PathVariable Long id) {
        stockOrderRepository.deleteById(id);
    }
}
