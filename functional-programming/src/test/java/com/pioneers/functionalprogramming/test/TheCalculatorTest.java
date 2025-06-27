package com.pioneers.functionalprogramming.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TheCalculatorTest {

    private TheCalculator calculator;


    @BeforeEach
    void setup() {
        calculator = new TheCalculator();
    }

    @Test
    void testAddWithTwoPositiveNumbers() {
        int actualResult = calculator.add(1, 2);

        assertEquals(3, actualResult);
    }

    @Test
    void testAddWithTwoNegativeNumbers() {
        int actualResult = calculator.add(-1, -2);

        assertEquals(-3, actualResult);
    }

    @Test
    void testAddWithZeroAndPositiveNumbers() {
        int actualResult = calculator.add(0, 5);

        assertEquals(5, actualResult);
    }

    @Test
    void testSubtractWithTwoPositiveNumbers() {

        // Arrange

        // Ack
        int actualResult = calculator.subtract(1, 2);

        // Assert
        assertEquals(-1, actualResult);
    }

    @Test
    void testSubtractWithTwoNegativeNumbers() {
        // Arrange

        // Ack
        int actualResult = calculator.subtract(-1, -2);

        // Assert
        assertEquals(1, actualResult);
    }
}
