package com.bruno13palhano.data.dao;

import com.bruno13palhano.data.model.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductDAO extends CrudRepository<ProductEntity, Long> {
    @Query(value = "UPDATE product_table p SET p.name = :product.name, p.code = :product.code, " +
            "p.description = :product.description, p.photo = :product.photo, p.date = :product.date, " +
            "p.categories = :product.categories, p.company = :product.company WHERE p.id = :product.id",
            nativeQuery = true)
    void update(@Param("product") ProductEntity product);
}
