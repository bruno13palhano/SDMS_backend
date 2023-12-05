package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.service.impl.DefaultVersionService;
import com.bruno13palhano.model.DataVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/version")
@RestController
@CrossOrigin
public class VersionController {

    @Autowired
    private DefaultVersionService defaultVersionService;

    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody DataVersion dataVersion) {
        defaultVersionService.insert(dataVersion);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody DataVersion dataVersion) {
        defaultVersionService.update(dataVersion);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        defaultVersionService.delete(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @RequestMapping(path = "/all")
    public ResponseEntity<List<DataVersion>> getAll() {
        return ResponseEntity.ok().body(defaultVersionService.getAll());
    }
}
