package com.bruno13palhano.data.service;

import com.bruno13palhano.model.Sale;
import com.bruno13palhano.model.SaleItems;

public interface SaleService extends Service<Sale>{
    void insert(SaleItems saleItems);
}
