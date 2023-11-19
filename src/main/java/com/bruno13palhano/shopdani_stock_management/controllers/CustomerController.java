package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.repository.CustomerRepository;
import com.bruno13palhano.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/customers")
@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(path = "/insert")
    void insert(@RequestBody Customer customer) {
        customerRepository.insert(customer);
    }

    @PutMapping(path = "/update")
    void update(@RequestBody Customer customer) {
        customerRepository.update(customer);
    }

    @GetMapping("/delete/{id}")
    void delete(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }

    @GetMapping("/all")
    Iterable<Customer> getAll() {
        return customerRepository.getAll();
    }
}
