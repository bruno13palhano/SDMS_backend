package com.bruno13palhano.model;

import java.util.List;

public class Product {
    private Long id;
    private String name;
    private String code;
    private String description;
    private byte[] photo;
    private Long date;
    private List<CategoryIn> categories;
    private String company;

    public Product() {}

    public Product(Long id, String name, String code, String description, byte[] photo, Long date,
                         List<CategoryIn> categories, String company) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.photo = photo;
        this.date = date;
        this.categories = categories;
        this.company = company;
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

    public List<CategoryIn> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryIn> categories) {
        this.categories = categories;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
