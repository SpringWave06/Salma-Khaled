package com.pioneers.functionalprogramming.service;

import com.pioneers.functionalprogramming.model.dto.Order;
import com.pioneers.functionalprogramming.rule.DiscountRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DiscountEngineImpl implements DiscountEngine {

    private final List<DiscountRule> discountRules;

    @Autowired
    public DiscountEngineImpl(List<DiscountRule> discountRules) {
        this.discountRules = discountRules;
    }

    @Override
    public BigDecimal applyDiscount(Order order) {
        BigDecimal totalPrice = order.calculateTotalPrice();

        return discountRules.stream()
                .reduce(totalPrice,
                        (currentPrice, rule) -> rule.apply(order, currentPrice),
                        (a, b) -> a);
    }
}
