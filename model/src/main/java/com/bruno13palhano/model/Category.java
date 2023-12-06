package com.bruno13palhano.model;

public class Category {
    private Long id;
    private String category;
    private String timestamp;

    public Category() {}

    public Category(Long id, String category, String timestamp) {
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
