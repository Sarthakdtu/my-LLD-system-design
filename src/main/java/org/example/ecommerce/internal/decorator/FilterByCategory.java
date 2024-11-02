package org.example.ecommerce.internal.decorator;

import org.example.ecommerce.internal.model.Product;
import org.example.ecommerce.internal.model.ProductCategory;

import java.util.List;
import java.util.stream.Collectors;

public class FilterByCategory extends AbstractFilter{
    private ProductCategory category;

    public FilterByCategory(FilterDecorator filterDecorator, ProductCategory category) {
        super(filterDecorator);
        this.category = category;
    }

    @Override
    public List<Product> filter(List<Product> products) {
        return filterDecorator.filter(products).stream().filter(it -> it.getCategory().equals(category)).collect(Collectors.toList());
    }

}
