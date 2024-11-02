package org.example.ecommerce.internal.decorator;

import org.example.ecommerce.internal.model.Product;
import org.example.ecommerce.internal.model.Rating;

import java.util.List;
import java.util.stream.Collectors;

public class FilterByRating extends AbstractFilter {

    private Rating rating;

    public FilterByRating(FilterDecorator filterDecorator, Rating rating) {
        super(filterDecorator);
        this.rating = rating;
    }

    @Override
    public List<Product> filter(List<Product> products) {
        return filterDecorator.filter(products)
                .stream()
                .filter(it -> it.getRating().equals(rating))
                .collect(Collectors.toList());
    }
}
