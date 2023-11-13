package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.Repository;
import com.bruno13palhano.data.Utils;
import com.bruno13palhano.data.dao.CategoryDAO;
import com.bruno13palhano.model.Category;
import org.springframework.context.annotation.Configuration;

import java.util.stream.StreamSupport;

@Configuration
public class CategoryRepository implements Repository<Category> {
    private final CategoryDAO categoryDAO;

    public CategoryRepository(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public void insert(Category data) {
        categoryDAO.save(Utils.categoryAsEntity(data));
    }

    @Override
    public void update(Category data) {
        categoryDAO.update(Utils.categoryAsEntity(data));
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Iterable<Category> getAll() {
        return StreamSupport
                .stream(categoryDAO.findAll().spliterator(), false)
                .map(Utils::categoryAsExternal).toList();
    }
}
