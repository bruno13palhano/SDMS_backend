package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.service.StockService;
import com.bruno13palhano.model.StockItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/items")
@RestController
@CrossOrigin
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<StockItem>> getAll() {
        return ResponseEntity.ok().body(stockService.getAll());
    }

    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody StockItem stockItem) {
        stockService.insert(stockItem);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody StockItem stockItem) {
        stockService.update(stockItem);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}/{quantity}")
    public ResponseEntity<?> updateItemQuantity(@PathVariable("id") Long id, @PathVariable("quantity") Integer quantity) {
        stockService.updateQuantity(id, quantity);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        stockService.delete(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
