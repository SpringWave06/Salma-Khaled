package com.pioneers.functionalprogramming.rule;

import com.pioneers.functionalprogramming.model.dto.Order;
import com.pioneers.functionalprogramming.model.dto.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BulkItemRule implements DiscountRule {
    @Override
    public BigDecimal apply(Order order, BigDecimal currentPrice) {
        boolean isDiscountMatched = order.products().stream()
                .anyMatch(BulkItemRule::isDiscountMatched);

        if (isDiscountMatched) {
            return currentPrice.multiply(BigDecimal.valueOf(0.95));
        }

        return currentPrice;
    }

    private static boolean isDiscountMatched(Product product) {
        return product.quantity() > 5;
    }
}
