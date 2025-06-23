package com.pioneers.functionalprogramming.service;

import com.pioneers.functionalprogramming.model.dto.Order;

import java.math.BigDecimal;

public interface DiscountEngine {

    BigDecimal applyDiscount(Order order);
}
