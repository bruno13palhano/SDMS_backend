package com.bruno13palhano.data.service.impl;

import com.bruno13palhano.data.Repository;
import com.bruno13palhano.data.service.SaleService;
import com.bruno13palhano.model.Sale;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultSaleService implements SaleService {
    private final Repository<Sale> repository;

    public DefaultSaleService(Repository<Sale> repository) {
        this.repository = repository;
    }

    @Override
    public void insert(Sale model) {
        repository.insert(model);
    }

    @Override
    public void update(Sale model) {
        repository.update(model);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Sale> getAll() {
        return repository.getAll();
    }
}
