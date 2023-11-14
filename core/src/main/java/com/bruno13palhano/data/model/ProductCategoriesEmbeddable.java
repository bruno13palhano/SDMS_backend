package com.bruno13palhano.data.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class ProductCategoriesEmbeddable {

    @Column(name = "categories", table = "product_categories_table")
    @ManyToMany
    private List<CategoryEntity> categories = new ArrayList<>();

    public ProductCategoriesEmbeddable() {}

    public ProductCategoriesEmbeddable(List<CategoryEntity> categories) {
        this.categories = categories;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories.addAll(categories);
    }
}
