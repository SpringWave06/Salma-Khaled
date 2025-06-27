package com.pioneers.functionalprogramming.discountengine.rule;

import com.pioneers.functionalprogramming.discountengine.model.dto.Order;

import java.math.BigDecimal;

@FunctionalInterface
public interface DiscountRule {

    BigDecimal apply(Order order, BigDecimal currentPrice);
}
