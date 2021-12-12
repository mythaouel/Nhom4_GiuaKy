package com.n04.g701.model;

public class Product {
    private String productID;
    private String productName;
    private String productBrand;
    private double productPrice;
    private byte[] productThumb;

    public Product(String productID, String productName, String productBrand, double productPrice, byte[] productThumb) {
        this.productID = productID;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productPrice = productPrice;
        this.productThumb = productThumb;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public byte[] getProductThumb() {
        return productThumb;
    }

    public void setProductThumb(byte[] productThumb) {
        this.productThumb = productThumb;
    }
}
