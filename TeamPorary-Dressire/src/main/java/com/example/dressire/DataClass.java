package com.example.dressire;

public class DataClass {
    private String imageUrl;
    private String productName;
    private String material;
    private String type;
    private String color;

    public DataClass(){

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public DataClass(String imageUrl, String productName, String material, String type, String color) {
        this.imageUrl = imageUrl;
        this.productName = productName;
        this.material = material;
        this.type = type;
        this.color = color;
    }

}
