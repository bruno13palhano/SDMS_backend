package com.bruno13palhano.data.dao;

import com.bruno13palhano.data.model.CategoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryDAO extends CrudRepository<CategoryEntity, Long> {
    @Query(value = "UPDATE category_table c SET c.category = :category.category WHERE c.id = :category.id", nativeQuery = true)
    void update(@Param("category") CategoryEntity category);
}
