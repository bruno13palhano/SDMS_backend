package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.repository.SaleRepository;
import com.bruno13palhano.data.repository.StockOrderRepository;
import com.bruno13palhano.model.Sale;
import com.bruno13palhano.model.StockOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sales")
@RestController
@CrossOrigin
public class SaleController {

    @Autowired
    private StockOrderRepository stockOrderRepository;

    @Autowired
    private SaleRepository saleRepository;

    @GetMapping("/insert")
    void insert() {
        Iterable<StockOrder> items = stockOrderRepository.getAll();
        StockOrder item = items.iterator().next();

        saleRepository.insert(
                new Sale(
                        0L,
                        item.getProductId(),
                        item.getId(),
                        1L,
                        item.getName(),
                        "Bruno",
                        item.getPhoto(),
                        10,
                        33.33F,
                        66.66F,
                        1.2F,
                        item.getCategories(),
                        item.getCompany(),
                        1111111L,
                        2222222L,
                        false,
                        true,
                        false
                )
        );
    }

    @GetMapping("/all")
    Iterable<Sale> getAll() {
        return saleRepository.getAll();
    }
}
