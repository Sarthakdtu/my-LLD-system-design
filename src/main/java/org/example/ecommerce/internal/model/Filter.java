package org.example.ecommerce.internal.model;

import javafx.util.Pair;

public class Filter {
    private Rating rating;
    private Pair<Double, Double> price;
    private ProductCategory productCategory;
    
    public Filter() {
        this.rating = null;
        this.price = null;
        this.productCategory = null;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setPrice(Pair<Double, Double> price) {
        this.price = price;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Rating getRating() {
        return rating;
    }

    public Pair<Double, Double> getPrice() {
        return price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }
}
