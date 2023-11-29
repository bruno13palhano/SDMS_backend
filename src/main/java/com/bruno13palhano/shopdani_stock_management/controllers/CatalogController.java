package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.repository.CatalogRepository;
import com.bruno13palhano.model.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/catalog")
@RestController
@CrossOrigin
public class CatalogController {

    @Autowired
    private CatalogRepository catalogRepository;

    @PostMapping(path = "/insert")
    void insert(@RequestBody Catalog catalog) {
        catalogRepository.insert(catalog);
    }

    @PutMapping(path = "/update")
    void update(@RequestBody Catalog catalog) {
        catalogRepository.update(catalog);
    }

    @DeleteMapping(path = "delete/{id}")
    void delete(@PathVariable Long id) {
        catalogRepository.deleteById(id);
    }

    @RequestMapping("/all")
    Iterable<Catalog> getAll() {
        return catalogRepository.getAll();
    }
}
