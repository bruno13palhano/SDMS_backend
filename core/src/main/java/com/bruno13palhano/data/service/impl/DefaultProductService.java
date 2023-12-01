package com.bruno13palhano.data.service.impl;

import com.bruno13palhano.data.Repository;
import com.bruno13palhano.data.repository.ProductRepository;
import com.bruno13palhano.data.service.ProductService;
import com.bruno13palhano.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProductService implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void insert(Product data) {
        productRepository.insert(data);
    }

    @Override
    public void update(Product data) {
        productRepository.update(data);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }
}
