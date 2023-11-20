package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.repository.DeliveryRepository;
import com.bruno13palhano.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/deliveries")
@RestController
@CrossOrigin
public class DeliveryController {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @PostMapping(path = "/insert")
    void insert(@RequestBody Delivery delivery) {
        deliveryRepository.insert(delivery);
    }

    @PutMapping(path = "/update")
    void update(@RequestBody Delivery delivery) {
        deliveryRepository.update(delivery);
    }

    @GetMapping(path = "/delete/{id}")
    void delete(@PathVariable Long id) {
        deliveryRepository.deleteById(id);
    }

    @GetMapping(path = "/all")
    Iterable<Delivery> getAll() {
        return deliveryRepository.getAll();
    }
}
