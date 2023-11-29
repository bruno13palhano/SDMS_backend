package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.repository.SaleRepository;
import com.bruno13palhano.data.repository.StockOrderRepository;
import com.bruno13palhano.model.Delivery;
import com.bruno13palhano.model.Sale;
import com.bruno13palhano.model.StockOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequestMapping("/sales")
@RestController
@CrossOrigin
public class SaleController {

    @Autowired
    private StockOrderRepository stockOrderRepository;

    @Autowired
    private SaleRepository saleRepository;

    @PostMapping(path = "/insert")
    void insert(@RequestBody SaleItems saleItems) {
        Sale sale = saleItems.sale;
        StockOrder stockOrder = saleItems.stockOrder;
        Delivery delivery = saleItems.delivery;

        saleRepository.insertItems(sale, stockOrder, delivery);
    }

    @PutMapping(path = "/update")
    void update(@RequestBody Sale sale) {
        saleRepository.update(sale);
    }

    @GetMapping(path = "delete/{id}")
    void delete(@PathVariable Long id) {
        saleRepository.deleteById(id);
    }

    @GetMapping("/all")
    Iterable<Sale> getAll() {
        return saleRepository.getAll();
    }

    static class SaleItems {
        private Sale sale;
        private StockOrder stockOrder;
        private Delivery delivery;

        SaleItems() {}

        SaleItems(Sale sale, StockOrder stockOrder, Delivery delivery) {
            this.sale = sale;
            this.stockOrder = stockOrder;
            this.delivery = delivery;
        }

        public Sale getSale() {
            return sale;
        }

        public void setSale(Sale sale) {
            this.sale = sale;
        }

        public StockOrder getStockOrder() {
            return stockOrder;
        }

        public void setStockOrder(StockOrder stockOrder) {
            this.stockOrder = stockOrder;
        }

        public Delivery getDelivery() {
            return delivery;
        }

        public void setDelivery(Delivery delivery) {
            this.delivery = delivery;
        }
    }
}
