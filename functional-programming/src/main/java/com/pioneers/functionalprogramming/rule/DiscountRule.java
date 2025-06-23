package com.pioneers.functionalprogramming.rule;

import com.pioneers.functionalprogramming.model.dto.Order;

import java.math.BigDecimal;

@FunctionalInterface
public interface DiscountRule {

    BigDecimal apply(Order order, BigDecimal currentPrice);
}
