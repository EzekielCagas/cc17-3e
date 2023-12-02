package com.example.dressire.Model;

public class Womens {
    private String name;
    private String imgUrl;
    private double price;
    private float rating;

    public Womens(String name, String imgUrl, double price, float rating) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
