package com.bruno13palhano.model;

import java.util.List;

public interface Items {
    Long getId();
    Long getProduct_id();
    String getName();
    byte[] getPhoto();
    Long getDate();
    Long getValidity();
    Integer getQuantity();
    String getCategories();
    String getCompany();
    Float getPurchase_price();
    Float getSale_price();
    Boolean getIs_ordered_by_customer();
    Boolean getIs_paid();
}
