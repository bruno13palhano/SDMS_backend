package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.repository.DeliveryRepository;
import com.bruno13palhano.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/deliveries")
@RestController
@CrossOrigin
public class DeliveryController {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @GetMapping("/insert")
    void insert() {
        deliveryRepository.insert(
                new Delivery(
                        0L,
                        1L,
                        "",
                        "",
                        "",
                        "",
                        0F,
                        1.2F,
                        1122L,
                        2211L,
                        false
                )
        );
    }
}
