package com.bruno13palhano.data.service.impl;

import com.bruno13palhano.data.Repository;
import com.bruno13palhano.data.service.CategoryService;
import com.bruno13palhano.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCategoryService implements CategoryService {
    private final Repository<Category> repository;

    public DefaultCategoryService(Repository<Category> repository) {
        this.repository = repository;
    }

    @Override
    public void insert(Category data) {
        repository.insert(data);
    }

    @Override
    public void update(Category data) {
        repository.update(data);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Category> getAll() {
        return repository.getAll();
    }
}
