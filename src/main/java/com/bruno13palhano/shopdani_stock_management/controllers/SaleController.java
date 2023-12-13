package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.service.impl.DefaultSaleService;
import com.bruno13palhano.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/sales")
@RestController
@CrossOrigin
public class SaleController {

    @Autowired
    private DefaultSaleService defaultSaleService;

    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody Sale sale) {
        defaultSaleService.insert(sale);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody Sale sale) {
        defaultSaleService.update(sale);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        defaultSaleService.delete(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Sale>> getAll() {
        return ResponseEntity.ok().body(defaultSaleService.getAll());
    }
}
