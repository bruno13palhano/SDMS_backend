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
    private String amazonCode;
    private Long amazonRequestNumber;
    private Integer amazonTax;
    private Float amazonProfit;
    private String amazonSKU;
    private Float resaleProfit;
    private Float totalProfit;
    private Long dateOfSale;
    private Long dateOfPayment;
    private Long shippingDate;
    private Long deliveryDate;
    private Boolean isOrderedByCustomer;
    private Boolean isPaidByCustomer;
    private Boolean delivered;
    private Boolean canceled;
    private Boolean isAmazon;
    private String timestamp;

    public Sale() {}

    public Sale(Long id, Long productId, Long stockId, Long customerId, String name, String customerName, byte[] photo,
                String address, String phoneNumber, Integer quantity, Float purchasePrice, Float salePrice,
                Float deliveryPrice, List<Category> categories, String company, String amazonCode,
                Long amazonRequestNumber, Integer amazonTax, Float amazonProfit, String amazonSKU, Float resaleProfit,
                Float totalProfit, Long dateOfSale, Long dateOfPayment, Long shippingDate, Long deliveryDate,
                Boolean isOrderedByCustomer, Boolean isPaidByCustomer, Boolean delivered, Boolean canceled,
                Boolean isAmazon, String timestamp) {
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
        this.amazonCode = amazonCode;
        this.amazonRequestNumber = amazonRequestNumber;
        this.amazonTax = amazonTax;
        this.amazonProfit = amazonProfit;
        this.amazonSKU = amazonSKU;
        this.resaleProfit = resaleProfit;
        this.totalProfit = totalProfit;
        this.dateOfSale = dateOfSale;
        this.dateOfPayment = dateOfPayment;
        this.shippingDate = shippingDate;
        this.deliveryDate = deliveryDate;
        this.isOrderedByCustomer = isOrderedByCustomer;
        this.isPaidByCustomer = isPaidByCustomer;
        this.delivered = delivered;
        this.canceled = canceled;
        this.isAmazon = isAmazon;
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

    public String getAmazonCode() {
        return amazonCode;
    }

    public void setAmazonCode(String amazonCode) {
        this.amazonCode = amazonCode;
    }

    public Long getAmazonRequestNumber() {
        return amazonRequestNumber;
    }

    public void setAmazonRequestNumber(Long amazonRequestNumber) {
        this.amazonRequestNumber = amazonRequestNumber;
    }

    public Integer getAmazonTax() {
        return amazonTax;
    }

    public void setAmazonTax(Integer amazonTax) {
        this.amazonTax = amazonTax;
    }

    public Float getAmazonProfit() {
        return amazonProfit;
    }

    public void setAmazonProfit(Float amazonProfit) {
        this.amazonProfit = amazonProfit;
    }

    public String getAmazonSKU() {
        return amazonSKU;
    }

    public void setAmazonSKU(String amazonSKU) {
        this.amazonSKU = amazonSKU;
    }

    public Float getResaleProfit() {
        return resaleProfit;
    }

    public void setResaleProfit(Float resaleProfit) {
        this.resaleProfit = resaleProfit;
    }

    public Float getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(Float totalProfit) {
        this.totalProfit = totalProfit;
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

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }

    public Boolean getCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }

    public Boolean getIsAmazon() {
        return isAmazon;
    }

    public void setIsAmazon(Boolean isAmazon) {
        this.isAmazon = isAmazon;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
