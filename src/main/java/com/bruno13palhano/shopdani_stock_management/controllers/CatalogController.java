package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.service.impl.DefaultCatalogService;
import com.bruno13palhano.model.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/catalog")
@RestController
@CrossOrigin
public class CatalogController {

    @Autowired
    private DefaultCatalogService defaultCatalogService;

    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody Catalog catalog) {
        defaultCatalogService.insert(catalog);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody Catalog catalog) {
        defaultCatalogService.update(catalog);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        defaultCatalogService.delete(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @RequestMapping("/all")
    public ResponseEntity<List<Catalog>> getAll() {
        return ResponseEntity.ok().body(defaultCatalogService.getAll());
    }
}
