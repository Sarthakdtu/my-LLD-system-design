package org.example.ecommerce.internal.decorator;

import org.example.ecommerce.internal.model.Product;
import org.example.ecommerce.internal.model.Rating;

import java.util.List;
import java.util.stream.Collectors;

public class FilterByPriceRange extends AbstractFilter {

    private Double low;
    private Double high;

    public FilterByPriceRange(FilterDecorator filterDecorator, Double low, Double high) {
        super(filterDecorator);
        this.low = low;
        this.high = high;
    }

    @Override
    public List<Product> filter(List<Product> products) {
        return filterDecorator.filter(products).stream().filter(it ->
            (it.getPrice() >= low && it.getPrice() <= high)
        ).collect(Collectors.toList());
    }
}
