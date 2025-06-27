package com.pioneers.functionalprogramming.discountengine.service;

import com.pioneers.functionalprogramming.discountengine.model.dto.Order;
import com.pioneers.functionalprogramming.discountengine.model.dto.Product;
import com.pioneers.functionalprogramming.discountengine.rule.BulkItemRule;
import com.pioneers.functionalprogramming.discountengine.rule.HighValueRule;
import com.pioneers.functionalprogramming.discountengine.rule.LaptopRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DiscountEngineImplTest {

    @Mock
    private LaptopRule laptopRule;
    @Mock
    private HighValueRule highValueRule;
    @Mock
    private BulkItemRule bulkItemRule;

    private DiscountEngineImpl discountEngine;

    @BeforeEach
    void setup() {
        discountEngine = new DiscountEngineImpl(Arrays.asList(laptopRule, highValueRule, bulkItemRule));
    }

    @Test
    void testApplyDiscountOnLaptopRule() {
        BigDecimal priceWithoutDiscount = BigDecimal.valueOf(50200);
        Order order = new Order(Arrays.asList(
                new Product("Laptop", 1, BigDecimal.valueOf(50000)),
                new Product("Mouse", 2, BigDecimal.valueOf(100))
        ));

        // Arrange
        when(laptopRule.apply(order, priceWithoutDiscount))
                .thenReturn(BigDecimal.valueOf(49700));

        when(highValueRule.apply(order, BigDecimal.valueOf(49700)))
                .thenReturn(BigDecimal.valueOf(49700));

        doReturn(BigDecimal.valueOf(49700))
                .when(bulkItemRule).apply(order, BigDecimal.valueOf(49700));

        // Ack
        BigDecimal priceWithDiscount = discountEngine.applyDiscount(order);

        // Assert
        assertEquals(0, priceWithDiscount.compareTo(BigDecimal.valueOf(49700)));
        verify(laptopRule).apply(order, priceWithoutDiscount);
        verify(highValueRule).apply(order, BigDecimal.valueOf(49700));
        verify(bulkItemRule).apply(order, BigDecimal.valueOf(49700));
    }

    // TODO: Create a unit test for the order includes 6 Mouses and 1 Laptop with 40000 price

    // TODO: Create a unit test for the order includes 6 Mouses and 1 Laptop with 50000 price, 4 Keyboards (but the most expensive keyboards)

    // TODO: Create a unit test for the order includes 1 Laptop with 50000 price, 4 Keyboards (but the most expensive keyboards)

    // TODO: Create a unit test for the order includes 1 Mouse, 1 Keyboards (but the most expensive keyboards)

    // TODO: Create a unit test for the order includes Nothing
}
