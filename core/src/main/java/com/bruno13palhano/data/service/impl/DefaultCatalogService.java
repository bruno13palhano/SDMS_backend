package com.bruno13palhano.data.service.impl;

import com.bruno13palhano.data.repository.CatalogRepository;
import com.bruno13palhano.data.service.CatalogService;
import com.bruno13palhano.model.Catalog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCatalogService implements CatalogService {
    private final CatalogRepository catalogRepository;

    public DefaultCatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public void insert(Catalog data) {
        catalogRepository.insert(data);
    }

    @Override
    public void update(Catalog data) {
        catalogRepository.update(data);
    }

    @Override
    public void delete(Long id) {
        catalogRepository.deleteById(id);
    }

    @Override
    public List<Catalog> getAll() {
        return catalogRepository.getAll();
    }
}
