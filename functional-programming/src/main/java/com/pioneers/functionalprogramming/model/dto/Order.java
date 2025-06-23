package com.pioneers.functionalprogramming.model.dto;

import java.math.BigDecimal;
import java.util.List;

public record Order(List<Product> products) {

    public BigDecimal calculateTotalPrice() {
        return products.stream()
                .map(Product::calculatePrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
