package com.bruno13palhano.model;

import java.time.OffsetDateTime;

public class Category {
    private Long id;
    private String category;
    private OffsetDateTime timestamp;

    public Category() {}

    public Category(Long id, String category, OffsetDateTime timestamp) {
        this.id = id;
        this.category = category;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
