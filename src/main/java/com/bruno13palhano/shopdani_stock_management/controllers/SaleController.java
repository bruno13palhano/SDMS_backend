package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.service.SaleService;
import com.bruno13palhano.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/sales")
@RestController
@CrossOrigin
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody Sale sale) {
        saleService.insert(sale);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody Sale sale) {
        saleService.update(sale);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        saleService.delete(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Sale>> getAll() {
        return ResponseEntity.ok().body(saleService.getAll());
    }
}
