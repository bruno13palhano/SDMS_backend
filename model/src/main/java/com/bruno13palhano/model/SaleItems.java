package com.bruno13palhano.model;

public class SaleItems {
    private Sale sale;
    private StockItem stockItem;
    private Delivery delivery;

    SaleItems() {}

    SaleItems(Sale sale, StockItem stockItem, Delivery delivery) {
        this.sale = sale;
        this.stockItem = stockItem;
        this.delivery = delivery;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public StockItem getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}