package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.service.impl.DefaultStockOrderService;
import com.bruno13palhano.model.StockOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/items")
@RestController
@CrossOrigin
public class StockOrdersController {

    @Autowired
    private DefaultStockOrderService defaultStockOrderService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<StockOrder>> getAll() {
        return ResponseEntity.ok().body(defaultStockOrderService.getAll());
    }

    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody StockOrder stockOrder) {
        defaultStockOrderService.insert(stockOrder);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "update")
    public ResponseEntity<?> update(@RequestBody StockOrder stockOrder) {
        defaultStockOrderService.update(stockOrder);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        defaultStockOrderService.delete(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
