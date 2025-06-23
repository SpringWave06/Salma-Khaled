package com.pioneers.functionalprogramming.controller;

import com.pioneers.functionalprogramming.model.dto.Order;
import com.pioneers.functionalprogramming.service.DiscountEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("discount")
public class DiscountController {

    private final DiscountEngine discountEngine;

    @Autowired
    public DiscountController(DiscountEngine discountEngine) {
        this.discountEngine = discountEngine;
    }

    @PostMapping("apply")
    public String applyDiscount(@RequestBody Order order) {
        return "The Total Price with the discount is: " + discountEngine.applyDiscount(order);
    }
}
