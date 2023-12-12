package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.service.impl.DefaultStockService;
import com.bruno13palhano.model.StockItem;
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
    private DefaultStockService defaultStockOrderService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<StockItem>> getAll() {
        return ResponseEntity.ok().body(defaultStockOrderService.getAll());
    }

    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody StockItem stockItem) {
        defaultStockOrderService.insert(stockItem);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody StockItem stockItem) {
        defaultStockOrderService.update(stockItem);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        defaultStockOrderService.delete(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
