package com.pioneers.functionalprogramming.discountengine.model.dto;

import java.math.BigDecimal;

public record Product(String name, int quantity, BigDecimal price) {

    public BigDecimal calculatePrice() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
