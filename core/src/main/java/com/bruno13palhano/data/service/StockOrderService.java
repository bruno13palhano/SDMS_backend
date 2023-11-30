package com.bruno13palhano.data.service;

import com.bruno13palhano.data.Repository;
import com.bruno13palhano.data.repository.StockOrderRepository;
import com.bruno13palhano.model.StockOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockOrderService implements Repository<StockOrder> {
    @Autowired
    private StockOrderRepository stockOrderRepository;

    @Override
    public void insert(StockOrder data) {
        stockOrderRepository.insert(data);
    }

    @Override
    public void update(StockOrder data) {
        stockOrderRepository.update(data);
    }

    @Override
    public void deleteById(Long id) {
        stockOrderRepository.deleteById(id);
    }

    @Override
    public List<StockOrder> getAll() {
        return stockOrderRepository.getAll();
    }
}
