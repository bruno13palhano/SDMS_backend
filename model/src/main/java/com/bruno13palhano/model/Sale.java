package com.bruno13palhano.model;

import java.util.List;

public class Sale {
    private Long id;
    private Long productId;
    private Long stockOrderId;
    private Long customerId;
    private String name;
    private String customerName;
    private byte[] photo;
    private Integer quantity;
    private Float purchasePrice;
    private Float salePrice;
    private Float deliveryPrice;
    private List<Category> categories;
    private String company;
    private Long dateOfSale;
    private Long dateOfPayment;
    private Boolean isOrderedByCustomer;
    private Boolean isPaidByCustomer;
    private Boolean canceled;

    public Sale() {}

    public Sale(Long id, Long productId, Long stockOrderId, Long customerId, String name, String customerName, byte[] photo,
                Integer quantity, Float purchasePrice, Float salePrice, Float deliveryPrice, List<Category> categories,
                String company, Long dateOfSale, Long dateOfPayment, Boolean isOrderedByCustomer, Boolean isPaidByCustomer,
                Boolean canceled) {
        this.id = id;
        this.productId = productId;
        this.stockOrderId = stockOrderId;
        this.customerId = customerId;
        this.name = name;
        this.customerName = customerName;
        this.photo = photo;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.deliveryPrice = deliveryPrice;
        this.categories = categories;
        this.company = company;
        this.dateOfSale = dateOfSale;
        this.dateOfPayment = dateOfPayment;
        this.isOrderedByCustomer = isOrderedByCustomer;
        this.isPaidByCustomer = isPaidByCustomer;
        this.canceled = canceled;

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

    public Long getStockOrderId() {
        return stockOrderId;
    }

    public void setStockOrderId(Long stockOrderId) {
        this.stockOrderId = stockOrderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
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

    public Float getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Float deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
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

    public Long getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(Long dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public Long getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Long dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public Boolean getIsOrderedByCustomer() {
        return isOrderedByCustomer;
    }

    public void setIsOrderedByCustomer(Boolean orderedByCustomer) {
        isOrderedByCustomer = orderedByCustomer;
    }

    public Boolean getIsPaidByCustomer() {
        return isPaidByCustomer;
    }

    public void setIsPaidByCustomer(Boolean paidByCustomer) {
        isPaidByCustomer = paidByCustomer;
    }

    public Boolean getCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }
}
