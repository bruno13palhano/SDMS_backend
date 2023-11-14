package com.bruno13palhano.model;

public class Catalog {
    private Long id;
    private Long productId;
    private String name;
    private byte[] photo;
    private String title;
    private String description;
    private Long discount;
    private Float price;

    public Catalog() {}

    public Catalog(Long id, Long productId, String name, byte[] photo, String title, String description, Long discount,
                   Float price) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.photo = photo;
        this.title = title;
        this.description = description;
        this.discount = discount;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
