package com.bruno13palhano.data;

import com.bruno13palhano.data.model.CategoryEntity;
import com.bruno13palhano.data.model.ProductEntity;
import com.bruno13palhano.model.Category;
import com.bruno13palhano.model.Product;

public class Utils {

    public static Category categoryAsExternal(CategoryEntity entity) {
        return new Category(
                entity.getId(),
                entity.getCategory()
        );
    }

    public static CategoryEntity categoryAsEntity(Category external) {
        return new CategoryEntity(
                external.getId(),
                external.getCategory()
        );
    }

    public static Product productAsExternal(ProductEntity entity) {
        return new Product(
            entity.getId(),
            entity.getName(),
            entity.getCode(),
            entity.getDescription(),
            entity.getPhoto(),
            entity.getDate(),
            entity.getCategories(),
            entity.getCompany()
        );
    }

    public static ProductEntity productAsEntity(Product external) {
        return new ProductEntity(
                external.getId(),
                external.getName(),
                external.getCode(),
                external.getDescription(),
                external.getPhoto(),
                external.getDate(),
                external.getCategories(),
                external.getCompany()
        );
    }
}
