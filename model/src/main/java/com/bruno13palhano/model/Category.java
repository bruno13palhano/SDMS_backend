package com.bruno13palhano.model;

import java.io.Serializable;

public class Category implements CategoryIn, Serializable {
    private Long id;
    private String category;

    public Category() {}

    public Category(Long id, String category) {
        this.id = id;
        this.category = category;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
