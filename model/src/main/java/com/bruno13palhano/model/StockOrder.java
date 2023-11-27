package com.bruno13palhano.model;

import java.time.OffsetDateTime;
import java.util.List;

public class StockOrder {
    private Long id;
    private Long productId;
    private String name;
    private byte[] photo;
    private Long date;
    private Long validity;
    private Integer quantity;
    private List<Category> categories;
    private String company;
    private Float purchasePrice;
    private Float salePrice;
    private Boolean isOrderedByCustomer;
    private Boolean isPaid;
    private OffsetDateTime timestamp;

    public StockOrder() {}

    public StockOrder(Long id, Long productId, String name, byte[] photo, Long date, Long validity, Integer quantity,
                      List<Category> categories, String company, Float purchasePrice, Float salePrice,
                      Boolean isOrderedByCustomer, Boolean isPaid, OffsetDateTime timestamp) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.photo = photo;
        this.date = date;
        this.validity = validity;
        this.quantity = quantity;
        this.categories = categories;
        this.company = company;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.isOrderedByCustomer = isOrderedByCustomer;
        this.isPaid = isPaid;
        this.timestamp = timestamp;
    }

    public Long getId() { return this.id; };

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() { return productId; };

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() { return name; };

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhoto() { return photo; };

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Long getDate() { return date; };

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getValidity() { return validity; };

    public void setValidity(Long validity) {
        this.validity = validity;
    }

    public Integer getQuantity() { return quantity; };

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Category> getCategories() { return categories; };

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getCompany() { return company; };

    public void setCompany(String company) {
        this.company = company;
    }

    public Float getPurchasePrice() { return purchasePrice; };

    public void setPurchasePrice(Float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Float getSalePrice() { return salePrice; };

    public void setSalePrice(Float salePrice) {
        this.salePrice = salePrice;
    }

    public Boolean getIsOrderedByCustomer() { return isOrderedByCustomer; };

    public void setOrderedByCustomer(Boolean orderedByCustomer) {
        isOrderedByCustomer = orderedByCustomer;
    }

    public Boolean getIsPaid() { return isPaid; };

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
