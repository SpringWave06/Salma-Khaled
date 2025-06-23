package com.pioneers.functionalprogramming.rule;

import com.pioneers.functionalprogramming.model.dto.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class HighValueRule implements DiscountRule {
    @Override
    public BigDecimal apply(Order order, BigDecimal currentPrice) {
        if (currentPrice.compareTo(BigDecimal.valueOf(500)) > 0) {
            return currentPrice.multiply(new BigDecimal("0.9"));
        }
        return currentPrice;
    }
}
