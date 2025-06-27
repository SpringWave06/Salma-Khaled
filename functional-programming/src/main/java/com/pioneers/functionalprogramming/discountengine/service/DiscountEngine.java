package com.pioneers.functionalprogramming.discountengine.service;

import com.pioneers.functionalprogramming.discountengine.model.dto.Order;

import java.math.BigDecimal;

/**
 * Functional Interface that apply any kind of discount rule on any order from the shop.
 *
 * @see com.pioneers.functionalprogramming.discountengine.rule.LaptopRule
 * @see com.pioneers.functionalprogramming.discountengine.rule.HighValueRule
 * @see com.pioneers.functionalprogramming.discountengine.rule.BulkItemRule
 *
 * @author Abdelaziz Said
 */
@FunctionalInterface
public interface DiscountEngine {

    /**
     * Generic abstract method to apply the discount on any kind of rule.
     *
     * @param order The order need to apply discount on it.
     * @return The price of the order after applying the discount and impossible to returns {@code null}
     */
    BigDecimal applyDiscount(Order order);
}
