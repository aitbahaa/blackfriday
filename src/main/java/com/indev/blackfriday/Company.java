package com.indev.blackfriday;

import java.util.LinkedList;
import java.util.List;

public class Company {
    public static final float PRODUCT_SALE_MARGIN = 0.2F; // 20 %
    private static final int PRODUCT_FIXED_SALES_QUANTITY = 5;
    private List<Product> products = new LinkedList<>();
    private int totalAssets=0;

    public float sells(String productType) {
        Product product = findProductByTypeName(productType);

        float salePrice = product.sells(PRODUCT_FIXED_SALES_QUANTITY);

        float saleMargin = calculateSaleMargin(salePrice);

        totalAssets += saleMargin;
        
        return salePrice + saleMargin;
    }

    private float calculateSaleMargin(float salePrice) {
        return salePrice * PRODUCT_SALE_MARGIN;
    }


    private Product findProductByTypeName(String typeName) {
        ProductType productType = ProductType.fromName(typeName);
        return products.stream().filter(product -> product.getProductType().equals(productType)).findFirst().get();
    }

    public void stock(int quantity , String productType, int price) {
        products.add(createProduct(quantity, productType, price));
        totalAssets+= quantity*price;
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
        //return products.stream().mapToInt(product -> product.getPrice() * product.getQuantity() ).sum();
        return totalAssets;
    }

    public Company blackFriday() {
        return this;
    }
}
