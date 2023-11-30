package com.bruno13palhano.data.service;

import com.bruno13palhano.model.Sale;
import com.bruno13palhano.model.SaleItems;

import java.util.List;

public interface SaleData {
    void insert(SaleItems saleItems);
    void update(Sale sale);
    void deleteById(Long id);
    List<Sale> getAll();
}
