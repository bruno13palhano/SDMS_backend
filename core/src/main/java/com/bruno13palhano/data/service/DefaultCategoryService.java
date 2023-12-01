package com.bruno13palhano.data.service;

import com.bruno13palhano.data.Repository;
import com.bruno13palhano.data.repository.CategoryRepository;
import com.bruno13palhano.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCategoryService implements Repository<Category> {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void insert(Category data) {
        categoryRepository.insert(data);
    }

    @Override
    public void update(Category data) {
        categoryRepository.update(data);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }
}
