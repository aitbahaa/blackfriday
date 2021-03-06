package com.indev.blackfriday;

class Product {
    private int quantity ;
    private int price;
    private ProductType productType;

    public Product(int quantity, int price, ProductType productType) {
        this.quantity = quantity;
        this.price = price;
        this.productType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public float sells(int quantityToSell){
        if (hasNotStock(quantityToSell)) throw new RuntimeException("no stock");
        this.quantity -= quantityToSell;
        return quantityToSell*price;
    }

    private boolean hasNotStock(int quantityToSell) {
        return quantity < quantityToSell ;
    }
}
