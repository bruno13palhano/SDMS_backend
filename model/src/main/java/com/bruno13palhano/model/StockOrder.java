package com.bruno13palhano.model;

import java.io.Serializable;
import java.util.List;

public class StockOrder implements Items, Serializable {
    private Long id;
    private Long productId;
    private String name;
    private byte[] photo;
    private Long date;
    private Long validity;
    private Integer quantity;
    private String categories;
    private String company;
    private Float purchasePrice;
    private Float salePrice;
    private Boolean isOrderedByCustomer;
    private Boolean isPaid;

    public StockOrder() {}

    public StockOrder(Long id, Long productId, String name, byte[] photo, Long date, Long validity, Integer quantity,
                      String categories, String company, Float purchasePrice, Float salePrice,
                      Boolean isOrderedByCustomer, Boolean isPaid) {
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
    }

    @Override
    public Long getId() { return this.id; };

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getProduct_id() { return productId; };

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String getName() { return name; };

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public byte[] getPhoto() { return photo; };

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public Long getDate() { return date; };

    public void setDate(Long date) {
        this.date = date;
    }

    @Override
    public Long getValidity() { return validity; };

    public void setValidity(Long validity) {
        this.validity = validity;
    }

    @Override
    public Integer getQuantity() { return quantity; };

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getCategories() { return categories; };

    public void setCategories(String categories) {
        this.categories = categories;
    }

    @Override
    public String getCompany() { return company; };

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public Float getPurchase_price() { return purchasePrice; };

    public void setPurchasePrice(Float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    @Override
    public Float getSale_price() { return salePrice; };

    public void setSalePrice(Float salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public Boolean getIs_ordered_by_customer() { return isOrderedByCustomer; };

    public void setOrderedByCustomer(Boolean orderedByCustomer) {
        isOrderedByCustomer = orderedByCustomer;
    }

    @Override
    public Boolean getIs_paid() { return isPaid; };

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }
}
