package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.repository.SaleRepository;
import com.bruno13palhano.data.repository.StockOrderRepository;
import com.bruno13palhano.model.Sale;
import com.bruno13palhano.model.StockOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/sales")
@RestController
@CrossOrigin
public class SaleController {

    @Autowired
    private StockOrderRepository stockOrderRepository;

    @Autowired
    private SaleRepository saleRepository;

    @PostMapping(path = "/insert")
    void insert(@RequestBody Sale sale) {
        saleRepository.insert(sale);
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
}
