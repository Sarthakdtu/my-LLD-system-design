package org.example.ecommerce.internal.model;

public class Product {
    private String title;
    private ProductCategory category;
    private Double price;
    private String description;
    private Rating rating;
    private String brand;


    public Double getPrice() {
        return price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public Rating getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
