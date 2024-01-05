package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.service.CatalogService;
import com.bruno13palhano.model.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/catalog")
@RestController
@CrossOrigin
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody Catalog catalog) {
        catalogService.insert(catalog);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody Catalog catalog) {
        catalogService.update(catalog);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        catalogService.delete(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @RequestMapping("/all")
    public ResponseEntity<List<Catalog>> getAll() {
        return ResponseEntity.ok().body(catalogService.getAll());
    }
}
