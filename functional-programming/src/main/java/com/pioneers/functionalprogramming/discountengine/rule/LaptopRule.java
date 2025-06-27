package com.pioneers.functionalprogramming.discountengine.rule;

import com.pioneers.functionalprogramming.discountengine.model.dto.Order;
import com.pioneers.functionalprogramming.discountengine.model.dto.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LaptopRule implements DiscountRule {
    @Override
    public BigDecimal apply(Order order, BigDecimal currentPrice) {
        boolean isDiscountMatched = order.products().stream()
                .anyMatch(LaptopRule::isNameMatched);

        if (isDiscountMatched) {
            return currentPrice.subtract(BigDecimal.valueOf(500));
        }

        return currentPrice;
    }

    private static boolean isNameMatched(Product product) {
        return product.name().equalsIgnoreCase("Laptop");
    }
}
