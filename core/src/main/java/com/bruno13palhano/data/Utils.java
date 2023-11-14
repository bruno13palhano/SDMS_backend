package com.bruno13palhano.data;

import com.bruno13palhano.data.model.CategoryEntity;
import com.bruno13palhano.data.model.ProductCategoriesEmbeddable;
import com.bruno13palhano.data.model.ProductEntity;
import com.bruno13palhano.model.Category;
import com.bruno13palhano.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static Category categoryAsExternal(CategoryEntity entity) {
        return new Category(
                entity.getId(),
                entity.getName()
        );
    }

    public static CategoryEntity categoryAsEntity(Category external) {
        return new CategoryEntity(
                external.getId(),
                external.getName()
        );
    }

    public static List<Category> categoriesAsExternal(ProductCategoriesEmbeddable entity) {
        List<Category> result = new ArrayList<>();
        entity.getCategories().forEach( c -> result.add(new Category(c.getId(), c.getName())));
        return result;
    }

    public static ProductCategoriesEmbeddable categoriesAsEntity(List<Category> external, Long productId) {
        List<CategoryEntity> categories = new ArrayList<>();
        external.forEach( e -> categories.add(new CategoryEntity(e.getId(), e.getName())));
        return new ProductCategoriesEmbeddable(categories);
    }

    public static Product productAsExternal(ProductEntity entity) {
        return new Product(
            entity.getId(),
            entity.getName(),
            entity.getCode(),
            entity.getDescription(),
            entity.getPhoto(),
            entity.getDate(),
            categoriesAsExternal(entity.getCategories()),
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
                categoriesAsEntity(external.getCategories(), external.getId()),
                external.getCompany()
        );
    }
}
