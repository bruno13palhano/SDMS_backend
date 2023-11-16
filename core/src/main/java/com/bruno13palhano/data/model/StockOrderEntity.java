package com.bruno13palhano.data.model;

import jakarta.persistence.*;

@Entity(name = "stock_order_table")
public class StockOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long productId;

    @Column
    private Long date;

    @Column
    private Long validity;

    @Column
    private Integer quantity;

    @Column
    private Float purchasePrice;

    @Column
    private Float salePrice;

    @Column
    private Boolean isOrderedByCustomer;

    @Column
    private Boolean isPaid;

    public StockOrderEntity() {}

    public StockOrderEntity(Long id, Long productId, Long date, Long validity, Integer quantity, Float purchasePrice,
                            Float salePrice, Boolean isOrderedByCustomer, Boolean isPaid) {
        this.id = id;
        this.productId = productId;
        this.date = date;
        this.validity = validity;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.isOrderedByCustomer = isOrderedByCustomer;
        this.isPaid = isPaid;
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

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getValidity() {
        return validity;
    }

    public void setValidity(Long validity) {
        this.validity = validity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Float salePrice) {
        this.salePrice = salePrice;
    }

    public Boolean getOrderedByCustomer() {
        return isOrderedByCustomer;
    }

    public void setOrderedByCustomer(Boolean orderedByCustomer) {
        isOrderedByCustomer = orderedByCustomer;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }
}
