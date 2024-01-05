package com.bruno13palhano.data.service.impl;

import com.bruno13palhano.data.repository.StockRepository;
import com.bruno13palhano.data.service.StockService;
import com.bruno13palhano.model.StockItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultStockService implements StockService {
    private final StockRepository stockRepository;

    public DefaultStockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public void insert(StockItem data) {
        stockRepository.insert(data);
    }

    @Override
    public void update(StockItem data) {
        stockRepository.update(data);
    }

    @Override
    public void delete(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public List<StockItem> getAll() {
        return stockRepository.getAll();
    }

    @Override
    public void updateQuantity(Long id, Integer quantity) {
        stockRepository.updateStockItemQuantity(id, quantity);
    }
}
