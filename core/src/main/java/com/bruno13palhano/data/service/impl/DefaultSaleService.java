package com.bruno13palhano.data.service.impl;

import com.bruno13palhano.data.repository.SaleRepository;
import com.bruno13palhano.data.service.SaleService;
import com.bruno13palhano.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultSaleService implements SaleService {
    @Autowired
    private SaleRepository saleRepository;

    @Override
    public void insert(Sale model) {
        saleRepository.insert(model);
    }

    @Override
    public void update(Sale model) {
        saleRepository.update(model);
    }

    @Override
    public void delete(Long id) {
        saleRepository.deleteById(id);
    }

    @Override
    public List<Sale> getAll() {
        return saleRepository.getAll();
    }
}
