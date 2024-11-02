package org.example.ecommerce.internal.service;

import org.example.ecommerce.internal.decorator.AbstractFilter;
import org.example.ecommerce.internal.decorator.FilterByCategory;
import org.example.ecommerce.internal.decorator.FilterDecorator;
import org.example.ecommerce.internal.model.Filter;
import org.example.ecommerce.internal.model.Product;
import org.example.ecommerce.internal.model.ProductCategory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private List<Product> productList;
    private static ProductService instance;

    private ProductService() {

    }

    public static ProductService getInstance() {
        if(instance == null)
            instance = new ProductService();
        return instance;
    }

    public List<Product> searchProducts(String searchText) {
        return productList
                .stream()
                .filter(it -> it.getTitle().contains(searchText) || it.getDescription().equals(searchText))
                .collect(Collectors.toList());
    }

    public List<Product> filterProducts(Filter filter) {
        FilterDecorator filterDecorator = new AbstractFilter(null);
        if(filter.getProductCategory() != null) {
            filterDecorator = new FilterByCategory(null, filter.getProductCategory());
        }
    }

}
