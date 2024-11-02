package org.example.ecommerce.internal.decorator;

import org.example.ecommerce.internal.model.Product;

import java.util.List;

public class AbstractFilter implements FilterDecorator {

    protected FilterDecorator filterDecorator;

    public AbstractFilter(FilterDecorator filterDecorator) {
        this.filterDecorator = filterDecorator;
    }

    @Override
    public List<Product> filter(List<Product> products) {
        return products;
    }
}
