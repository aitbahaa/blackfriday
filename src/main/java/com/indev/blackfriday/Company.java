package com.indev.blackfriday;

import java.util.LinkedList;
import java.util.List;

public class Company {
    private List<Product> products = new LinkedList<>();

    public float sells(String capsule) {
        return 0;
    }

    public void stock(int quantity , String productType, int price) {
        products.add(createProduct(quantity, productType, price));
    }

    private Product createProduct(int quantity, String productType, int price) {
       return new Product(quantity,price, ProductType.fromName(productType));
    }

    public Company to(int i) {
        return this;
    }

    public float computeBenefit() {
        return 0;
    }

    public int totalAssets() {
        return products.stream().mapToInt(product -> product.getPrice() * product.getQuantity() ).sum();
    }

    public Company blackFriday() {
        return this;
    }
}
