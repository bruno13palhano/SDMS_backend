package com.bruno13palhano.data.service;

import com.bruno13palhano.model.StockItem;

public interface StockService extends Service<StockItem> {
    void updateQuantity(Long id, Integer quantity);
}
