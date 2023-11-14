package com.bruno13palhano.data.model;

import jakarta.persistence.*;

@Entity(name = "product_table")
@SecondaryTable(name = "product_categories_table", pkJoinColumns = @PrimaryKeyJoinColumn(name = "product_id"))
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String code;

    @Column
    private String description;

    @Column
    private byte[] photo;

    @Column
    private Long date;

    @Embedded
    private ProductCategoriesEmbeddable categories;

    @Column
    private String company;

    public ProductEntity() {}

    public ProductEntity(Long id, String name, String code, String description, byte[] photo, Long date,
                         ProductCategoriesEmbeddable categories, String company) {
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

    public ProductCategoriesEmbeddable getCategories() {
        return categories;
    }

    public void setCategories(ProductCategoriesEmbeddable categories) {
        this.categories = categories;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
