package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.service.impl.DefaultDeliveryService;
import com.bruno13palhano.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/deliveries")
@RestController
@CrossOrigin
public class DeliveryController {

    @Autowired
    private DefaultDeliveryService defaultDeliveryService;

    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody Delivery delivery) {
        defaultDeliveryService.insert(delivery);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody Delivery delivery) {
        defaultDeliveryService.update(delivery);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        defaultDeliveryService.delete(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Delivery>> getAll() {
        return ResponseEntity.ok().body(defaultDeliveryService.getAll());
    }
}
