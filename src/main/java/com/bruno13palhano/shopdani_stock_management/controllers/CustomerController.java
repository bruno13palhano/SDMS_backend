package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.service.impl.DefaultCustomerService;
import com.bruno13palhano.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customers")
@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    private DefaultCustomerService customerService;

    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody Customer customer) {
        customerService.insert(customer);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody Customer customer) {
        customerService.update(customer);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        customerService.delete(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok().body(customerService.getAll());
    }
}
