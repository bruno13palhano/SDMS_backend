package com.bruno13palhano.data.service.impl;

import com.bruno13palhano.data.repository.CategoryRepository;
import com.bruno13palhano.data.service.CategoryService;
import com.bruno13palhano.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCategoryService implements CategoryService {
    private final CategoryRepository categoryRepository;

    public DefaultCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void insert(Category data) {
        categoryRepository.insert(data);
    }

    @Override
    public void update(Category data) {
        categoryRepository.update(data);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }
}
