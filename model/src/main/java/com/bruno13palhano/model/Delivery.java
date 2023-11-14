package com.bruno13palhano.model;

public class Delivery {
    private Long id;
    private Long saleId;
    private String customerName;
    private String address;
    private String phoneNumber;
    private String productName;
    private Float price;
    private Float deliveryPrice;
    private Long shippingDate;
    private Long deliveryDate;
    private Boolean delivered;

    public Delivery() {}

    public Delivery(Long id, Long saleId, String customerName, String address, String phoneNumber, String productName,
                    Float price, Float deliveryPrice, Long shippingDate, Long deliveryDate, Boolean delivered) {
        this.id = id;
        this.saleId = saleId;
        this.customerName = customerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.productName = productName;
        this.price = price;
        this.deliveryPrice = deliveryPrice;
        this.shippingDate = shippingDate;
        this.deliveryDate = deliveryDate;
        this.delivered = delivered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Float deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
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

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }
}
