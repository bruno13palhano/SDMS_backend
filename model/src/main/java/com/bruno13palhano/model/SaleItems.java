package com.bruno13palhano.model;

public class SaleItems {
    private Sale sale;
    private StockOrder stockOrder;
    private Delivery delivery;

    SaleItems() {}

    SaleItems(Sale sale, StockOrder stockOrder, Delivery delivery) {
        this.sale = sale;
        this.stockOrder = stockOrder;
        this.delivery = delivery;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public StockOrder getStockOrder() {
        return stockOrder;
    }

    public void setStockOrder(StockOrder stockOrder) {
        this.stockOrder = stockOrder;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}