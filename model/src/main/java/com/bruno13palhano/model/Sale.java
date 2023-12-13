package com.bruno13palhano.model;

import java.util.List;

public class Sale {
    private Long id;
    private Long productId;
    private Long stockId;
    private Long customerId;
    private String name;
    private String customerName;
    private byte[] photo;
    private String address;
    private String phoneNumber;
    private Integer quantity;
    private Float purchasePrice;
    private Float salePrice;
    private Float deliveryPrice;
    private List<Category> categories;
    private String company;
    private Long dateOfSale;
    private Long dateOfPayment;
    private Long shippingDate;
    private Long deliveryDate;
    private Boolean isOrderedByCustomer;
    private Boolean isPaidByCustomer;
    private Boolean delivered;
    private Boolean canceled;
    private String timestamp;

    public Sale() {}

    public Sale(Long id, Long productId, Long stockId, Long customerId, String name, String customerName, byte[] photo,
                String address, String phoneNumber, Integer quantity, Float purchasePrice, Float salePrice, Float deliveryPrice, List<Category> categories,
                String company, Long dateOfSale, Long dateOfPayment, Long shippingDate, Long deliveryDate, Boolean isOrderedByCustomer,
                Boolean isPaidByCustomer, Boolean delivered, Boolean canceled, String timestamp) {
        this.id = id;
        this.productId = productId;
        this.stockId = stockId;
        this.customerId = customerId;
        this.name = name;
        this.customerName = customerName;
        this.photo = photo;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.deliveryPrice = deliveryPrice;
        this.categories = categories;
        this.company = company;
        this.dateOfSale = dateOfSale;
        this.dateOfPayment = dateOfPayment;
        this.shippingDate = shippingDate;
        this.deliveryDate = deliveryDate;
        this.isOrderedByCustomer = isOrderedByCustomer;
        this.isPaidByCustomer = isPaidByCustomer;
        this.delivered = delivered;
        this.canceled = canceled;
        this.timestamp = timestamp;
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

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Long getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Long shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Long getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Long deliveryDate) {
        this.deliveryDate = deliveryDate;
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

    public Boolean getOrderedByCustomer() {
        return isOrderedByCustomer;
    }

    public void setOrderedByCustomer(Boolean orderedByCustomer) {
        isOrderedByCustomer = orderedByCustomer;
    }

    public Boolean getPaidByCustomer() {
        return isPaidByCustomer;
    }

    public void setPaidByCustomer(Boolean paidByCustomer) {
        isPaidByCustomer = paidByCustomer;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
