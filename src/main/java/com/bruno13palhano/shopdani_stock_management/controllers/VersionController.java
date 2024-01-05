package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.service.VersionService;
import com.bruno13palhano.model.DataVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/version")
@RestController
@CrossOrigin
public class VersionController {

    @Autowired
    private VersionService versionService;

    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody DataVersion dataVersion) {
        versionService.insert(dataVersion);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody DataVersion dataVersion) {
        versionService.update(dataVersion);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        versionService.delete(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @RequestMapping(path = "/all")
    public ResponseEntity<List<DataVersion>> getAll() {
        return ResponseEntity.ok().body(versionService.getAll());
    }
}
