package com.bruno13palhano.data.service.impl;

import com.bruno13palhano.data.repository.CustomerRepository;
import com.bruno13palhano.data.service.CustomerService;
import com.bruno13palhano.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCustomerService implements CustomerService {
    private final CustomerRepository customerRepository;

    public DefaultCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void insert(Customer data) {
        customerRepository.insert(data);
    }

    @Override
    public void update(Customer data) {
        customerRepository.update(data);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }
}
