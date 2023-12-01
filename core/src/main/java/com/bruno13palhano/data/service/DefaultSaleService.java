package com.bruno13palhano.data.service;

import com.bruno13palhano.data.repository.SaleRepository;
import com.bruno13palhano.model.Sale;
import com.bruno13palhano.model.SaleItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultSaleService implements SaleService {
    @Autowired
    private SaleRepository saleRepository;

    @Override
    public void insert(SaleItems saleItems) {
        saleRepository.insertItems(saleItems.getSale(), saleItems.getStockOrder(), saleItems.getDelivery());
    }

    @Override
    public void insert(Sale model) {

    }

    @Override
    public void update(Sale sale) {
        saleRepository.update(sale);
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
