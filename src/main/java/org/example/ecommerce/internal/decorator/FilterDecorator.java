package org.example.ecommerce.internal.decorator;

import org.example.ecommerce.internal.model.Product;

import java.util.List;

public interface FilterDecorator {
    List<Product>  filter(List<Product> products);

}
