package com.indev.blackfriday;

enum ProductType {
    CAPSULE("capsule"),
    MACHINE("machine")
    ;

    private String name;

    ProductType(String name) {
        this.name = name;
    }

    public static ProductType fromName(String name){
        for (ProductType productType: ProductType.values() ) {
            if (productType.name.equals(name)){
                return productType;
            }
        }
        throw new IllegalArgumentException(name);
    }
}
