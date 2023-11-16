package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.Repository;
import com.bruno13palhano.data.dao.StockOrderDAO;
import com.bruno13palhano.data.model.StockOrderEntity;
import com.bruno13palhano.model.Items;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StockOrderRepository implements Repository<Items> {
    private final StockOrderDAO stockOrderDAO;

    public StockOrderRepository(StockOrderDAO stockOrderDAO) {
        this.stockOrderDAO = stockOrderDAO;
    }

    @Override
    public void insert(Items data) {
        stockOrderDAO.save(
                new StockOrderEntity(
                        data.getId(),
                        data.getProduct_id(),
                        data.getDate(),
                        data.getValidity(),
                        data.getQuantity(),
                        data.getPurchase_price(),
                        data.getSale_price(),
                        data.getIs_ordered_by_customer(),
                        data.getIs_paid()
                )
        );
    }

    @Override
    public void update(Items data) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Iterable<Items> getAll() {
        return stockOrderDAO.getAll();
    }
}
