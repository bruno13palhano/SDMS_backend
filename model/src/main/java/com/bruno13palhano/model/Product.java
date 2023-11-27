package com.bruno13palhano.model;

import java.time.OffsetDateTime;
import java.util.List;

public class Product {
    private Long id;
    private String name;
    private String code;
    private String description;
    private byte[] photo;
    private Long date;
    private List<Category> categories;
    private String company;
    private OffsetDateTime timestamp;

    public Product() {}

    public Product(Long id, String name, String code, String description, byte[] photo, Long date,
                         List<Category> categories, String company, OffsetDateTime timestamp) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.photo = photo;
        this.date = date;
        this.categories = categories;
        this.company = company;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
