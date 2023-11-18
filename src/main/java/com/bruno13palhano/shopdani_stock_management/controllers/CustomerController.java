package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.repository.CustomerRepository;
import com.bruno13palhano.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/customers")
@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/insert")
    void insert() {
        customerRepository.insert(
                new Customer(
                        0L,
                        "Bruno Barbosa",
                        new byte[] {},
                        "bruno13palhano@gmail.com",
                        "Rua 15 de Novembro",
                        "1111111"
                )
        );
    }

    @GetMapping("/all")
    Iterable<Customer> getAll() {
        return customerRepository.getAll();
    }
}
