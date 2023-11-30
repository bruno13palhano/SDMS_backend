package com.bruno13palhano.data.service;

import com.bruno13palhano.data.Repository;
import com.bruno13palhano.data.repository.CatalogRepository;
import com.bruno13palhano.model.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService implements Repository<Catalog> {
    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    public void insert(Catalog data) {
        catalogRepository.insert(data);
    }

    @Override
    public void update(Catalog data) {
        catalogRepository.update(data);
    }

    @Override
    public void deleteById(Long id) {
        catalogRepository.deleteById(id);
    }

    @Override
    public List<Catalog> getAll() {
        return catalogRepository.getAll();
    }
}
